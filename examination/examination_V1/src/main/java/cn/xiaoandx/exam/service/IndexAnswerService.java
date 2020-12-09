/*
 * Copyright 2019-2020 the original WEI.ZHOU.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.xiaoandx.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiaoandx.commons.core.DaoCode;
import cn.xiaoandx.commons.core.Parameter;
import cn.xiaoandx.commons.core.PublicErrorCode;
import cn.xiaoandx.commons.exception.CommonException;
import cn.xiaoandx.exam.dao.AnswerRecordDao;
import cn.xiaoandx.exam.dao.DayAnswerStatisticsDao;
import cn.xiaoandx.exam.dao.QuestionDao;
import cn.xiaoandx.exam.dao.QuestionOptionDao;
import cn.xiaoandx.exam.dao.TotalCollcetDao;
import cn.xiaoandx.exam.entity.DayAnswerStatistics;
import cn.xiaoandx.exam.entity.Question;
import cn.xiaoandx.exam.entity.QuestionOption;
import cn.xiaoandx.exam.entity.TotalCollcetSubject;
import cn.xiaoandx.exam.vo.AboutMe;
import cn.xiaoandx.exam.vo.AnswerRanking;
import cn.xiaoandx.exam.vo.AnswerRankingVo;
import cn.xiaoandx.exam.vo.AnswerUser;
import cn.xiaoandx.user.dao.UserDao;

/**  
 * <p> 
 *	答题，统计模块Service
 * </p> 
 * @ClassName:IndexAnswerService   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:22
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Service
@Transactional
public class IndexAnswerService implements DaoCode, Parameter {
	@Autowired
	private TotalCollcetDao totalCollcetDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private QuestionOptionDao questionOptionDao;
	@Autowired
	private AnswerRecordDao answerRecordDao;
	@Autowired
	private DayAnswerStatisticsDao dayAnswerStatisticsDao;
	@Autowired
	private UserDao userDao;

	/**
	 * <p>
	 * 	根据userId查询总成绩
	 * </p>
	 * 
	 * @Title: findSrcoeByOpenId
	 * @version:V1.0
	 * @param userId 用户id
	 * @return:TotalCollcetSubject xx用户的汇总数据对象（包括总分）
	 */
	@Transactional(readOnly = true)
	public TotalCollcetSubject findSrcoeByOpenId(int userId) {
		if (ENTER_NUMBER != userId) {
			TotalCollcetSubject total = totalCollcetDao.findSrcoeByOpenId(userId);
			total.setJurisdiction(userDao.findByUsersId(userId).getJurisdiction());
			return total;
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "参数用户Id异常");
	}

	/**
	 * <p>
	 * 	查询排名
	 * </p>
	 * 
	 * @Title: findRanking
	 * @version:V1.0
	 * @return:List<TotalCollcetSubject> 用户排名集合
	 */
	public List<AnswerRanking> findRanking() {
		return totalCollcetDao.findRanking();
	}

	/**
	 * <p>
	 * 	随机抽出一道题（包括选项）
	 * </p>
	 * 
	 * @Title: findById
	 * @version:V1.0
	 * @param id 随机id
	 * @return:Question 返回试题对象
	 */
	@Transactional(readOnly = true)
	public Question findById(String id) {
		Question question = questionDao.findById(id);
		if (null != question && question.getContent().length() != ENTER_NUMBER) {
			List<QuestionOption> options = questionOptionDao.findById(id);
			// 去掉选项内容中的A；等
			for (QuestionOption q : options) {
				q.setOptionContent(q.getOptionContent().split("：")[1]);
			}
			question.setQuestionOptions(options);
		} else {
			throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "无试题");
		}
		return question;
	}

	/**
	 * <p>
	 *	 提交答案（判断正确更新答题记录数据）
	 * </p>
	 * 
	 * @Title: answer
	 * @version:V1.0
	 * @param answerUser 用户选择答案对象
	 * @return:TotalCollcetSubject xx用户的汇总数据
	 */
	public TotalCollcetSubject answer(AnswerUser answerUser) {
		if (null != answerUser && ENTER_NUMBER != answerUser.getUserId()) {
			// 1.先获得正确答案
			Question question = questionDao.findById(answerUser.getQuestionId());
			// 1.2判断当前的总分是否为0
			TotalCollcetSubject totl = totalCollcetDao.findByUserID(answerUser.getUserId());
			// 2.添加答题记录表
			int addNumberOne = answerRecordDao.addQuestion(question, answerUser);
			// 回答正确
			if (question.getAnswer().equals(answerUser.getCorrectAnswer())) {
				// 3.添加每日答题记录表
				if (ADD_ERROR != addNumberOne) {
					List<DayAnswerStatistics> listDayAnswer = dayAnswerStatisticsDao.findBy(answerUser);
					if (ADD_ERROR != listDayAnswer.size()) {
						int updateNumber = dayAnswerStatisticsDao.updateok(question, answerUser);
						if (ADD_ERROR == updateNumber) {
							throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "更新每日答题记录表异常");
						}
					} else {
						int addNumberDay = dayAnswerStatisticsDao.add(question, answerUser);
						if (ADD_ERROR == addNumberDay) {
							throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "插入每日记录表异常");
						}
					}
				} else {
					throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "插入答题记录表异常");
				}
				// 更新答题汇总表
				List<TotalCollcetSubject> listTota = totalCollcetDao.findByUserId(answerUser.getUserId());
				if (ADD_ERROR != listTota.size()) {
					int updateNumberTwo = totalCollcetDao.updateUserok(question, answerUser);
					if (ADD_ERROR == updateNumberTwo) {
						throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "更新汇总表记录表异常");
					}
				} else {
					int addNumberTwo = totalCollcetDao.addTotaUser(question, answerUser);
					if (ADD_ERROR == addNumberTwo) {
						throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "插入汇总表记录表异常");
					}
				}
				// 答案错误
			} else {
				// 3.添加每日答题记录表
				if (ADD_ERROR != addNumberOne) {
					List<DayAnswerStatistics> listDayAnswer = dayAnswerStatisticsDao.findBy(answerUser);
					if (ADD_ERROR != listDayAnswer.size()) {
						// 获取当天的成绩--------
						DayAnswerStatistics day = dayAnswerStatisticsDao.findByIdAndTime(answerUser);
						int updateNumber;
						// 判断是否总分是否为0
						if (day.getSameDayScore() == SROCE_NUMBER) {
							// 不扣分-----
							updateNumber = dayAnswerStatisticsDao.updateError(question, answerUser, 0);
						} else {
							updateNumber = dayAnswerStatisticsDao.updateError(question, answerUser, 5);
						}
						if (ADD_ERROR == updateNumber) {
							throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "更新每日答题记录表异常");
						}
					} else {
						int addNumberDay = dayAnswerStatisticsDao.addError(question, answerUser);
						if (ADD_ERROR == addNumberDay) {
							throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "插入每日记录表异常");
						}
					}
				} else {
					throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "插入答题记录表异常");
				}
				// 更新答题汇总表
				List<TotalCollcetSubject> listTota = totalCollcetDao.findByUserId(answerUser.getUserId());
				if (ADD_ERROR != listTota.size()) {
					int updateNumberTwo;
					if (ENTER_NUMBER != totl.getTotalFraction()) {
						updateNumberTwo = totalCollcetDao.updateUserError(question, answerUser);
					} else {
						updateNumberTwo = totalCollcetDao.updateUserErrorTo(question, answerUser);
					}
					if (ADD_ERROR == updateNumberTwo) {
						throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "更新汇总表记录表异常");
					}
				} else {
					int addNumberTwo = totalCollcetDao.addTotaUser(question, answerUser);
					if (ADD_ERROR == addNumberTwo) {
						throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "插入汇总表记录表异常");
					}
				}
			}
			// 返回一个汇总表的对象
		} else {
			throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "参数异常");
		}
		return totalCollcetDao.findByUserID(answerUser.getUserId());
	}

	/**
	 * <p>
	 * 获取关于我页面数据
	 * </p>
	 * 
	 * @Title: findAllById
	 * @version:V1.0
	 * @param userId 用户id
	 * @return:AboutMe 关于我的所有数据对象
	 */
	@Transactional(readOnly = true)
	public AboutMe findAllById(Integer userId) {
		if (ENTER_NUMBER != userId) {
			AboutMe aboutMe = new AboutMe();
			// 获取xx用户排名即总分信息
			aboutMe.setAnswerRanking(totalCollcetDao.findUserRanking(userId));
			// 获取汇总数据
			aboutMe.setTotalCollcetSubject(totalCollcetDao.findByUserID(userId));
			// 获取xx用户的擅长的知识领域
			aboutMe.setAnswerRecord(answerRecordDao.findKDByUserId(userId));
			// 获取xx用户的每日答题记录
			aboutMe.setUserDayAnswer(dayAnswerStatisticsDao.findDayAnswer(userId));
			// 返回用户信息对象
			return aboutMe;
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "userId is null");
	}

	/**  
	 *<p> </p> 
	 * @Title: findRankingList    
	 * @version:V1.0     
	 * @return    
	 * @return:List<AnswerRankingVo>
	 */
	public List<AnswerRankingVo> findRankingList() {
		// TODO Auto-generated method stub
		return totalCollcetDao.findRankingList();
	}
}
