/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and 
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 * 
 *                        <xiaoandx@gmail.com>
 */
package club.xiaoandx.expound.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**  
 * <p> 创建形模式-生成器 </p> 
 *	说明：将一个复杂对象德构建与它德表示分离，使得同样德构建过程可以创建不同德表示</br>
 *	案例：</br>
 *		要解决了如何选择具体导出数据方式的问题，如何实现导出成文本、Xml等具体的格式，接下来就讨论这个问题。</br>
 *		对于导出数据的应用框架，通常对于具体的导出内容和格式是有要求的，假如现在有如下的要求，简单描述一下：</br>
 *		导出的文件，不管什么格式，都分成三个部分，分别是文件头、文件体和文件尾.</br>
 *		文件头部分，需要描述如下信息：分公司或门市点编号、导出数据的日期，对于文本格式，中间用逗号分隔</br>
 *		在文件体部分，需要描述如下信息：表名称、然后分条描述数据。对于文本格式，表名称单独占一行，数据描述一行算一条数据，字段间用逗号分隔。</br>
 *		在文件尾部分，需要描述如下信息：输出人</br>
 *	思路：</br>
 *		应用生成器模式来解决的思路.仔细分析上面的实现，构建每种格式的数据文件的处理过程，这不就是构建过程吗？</br>
 *		而每种格式具体的步骤实现，不就相当于是不同的表示吗？因为不同的步骤实现，决定了最终的表现也就不同.
 *
 * @ClassName:Builder   
 * @author: WEI.ZHOU
 * @date: 2021-04-04 13:39
 * @since: JDK1.8
 * @version V1.0.0
 */
//========================================= 构建测试 ==================================
public class Builder {
	public static void main(String[] args) {
		// 准备测试数据
		ExportHeaderModel ehm = new ExportHeaderModel();
		ehm.setDepId("一分公司");
		ehm.setExportDate("2010-05-18");

		Map<String, Collection<ExportDataModel>> mapData = new HashMap<String, Collection<ExportDataModel>>();
		Collection<ExportDataModel> col = new ArrayList<ExportDataModel>();

		ExportDataModel edm1 = new ExportDataModel();
		edm1.setProductId("产品001号");
		edm1.setPrice(100);
		edm1.setAmount(80);

		ExportDataModel edm2 = new ExportDataModel();
		edm2.setProductId("产品002号");
		edm2.setPrice(99);
		edm2.setAmount(55);
		// 把数据组装起来
		col.add(edm1);
		col.add(edm2);
		mapData.put("销售记录表", col);

		ExportFooterModel efm = new ExportFooterModel();
		efm.setExportUser("张三");

		// 测试输出到文本文件
		TxtBuilder txtBuilder = new TxtBuilder();
		// 创建指导者对象
		Director director = new Director(txtBuilder);
		director.construct(ehm, mapData, efm);
		// 把要输出的内容输出到控制台看看
		System.out.println("输出到文本文件的内容：\n" + txtBuilder.getResult());
		
		
		// 测试输出到xml文件
		XmlBuilder xmlBuilder = new XmlBuilder();
		Director director2 = new Director(xmlBuilder);
		director2.construct(ehm, mapData, efm);
		// 把要输出的内容输出到控制台看看
		System.out.println("输出到XML文件的内容：\n" + xmlBuilder.getResult());
	}
}

//	=================================== 文件内容对象实体 头部、内容数据、结尾 ===================
/**
 * 描述输出到文件头的内容的对象
 */
class ExportHeaderModel {
  /**
   * 分公司或门市点编号
   */
  private String depId;
  /**
   * 导出数据的日期
   */
  private String exportDate;
  public String getDepId() {
     return depId;
  }
  public void setDepId(String depId) {
     this.depId = depId;
  }
  public String getExportDate() {
     return exportDate;
  }
  public void setExportDate(String exportDate) {
     this.exportDate = exportDate;
  }
}

/**
 * 描述输出数据的对象
 */
class ExportDataModel {
  /**
   * 产品编号
   */
  private String productId;
  /**
   * 销售价格
   */
  private double price;
  /**
   * 销售数量
   */
  private double amount;

  public String getProductId() {
     return productId;
  }
  public void setProductId(String productId) {
     this.productId = productId;
  }
  public double getPrice() {
     return price;
  }
  public void setPrice(double price) {
     this.price = price;
  }
  public double getAmount() {
     return amount;
  }
  public void setAmount(double amount) {
     this.amount = amount;
  }
}

/**
 * 描述输出到文件尾的内容的对象
 */
class ExportFooterModel {
  /**
   * 输出人
   */
  private String exportUser;
  public String getExportUser() {
     return exportUser;
  }
  public void setExportUser(String exportUser) {
     this.exportUser = exportUser;
  }
}

//	========================================== Buider 具体实现 ================================

/**
 * 生成器接口，定义创建一个输出文件对象所需的各个部件的操作
 */
 interface BuilderInterFace {
  /**
   * 构建输出文件的Header部分
   * @param ehm 文件头的内容
   */
  public void buildHeader(ExportHeaderModel ehm);
  /**
   * 构建输出文件的Body部分
   * @param mapData 要输出的数据的内容
   */
  public void buildBody(Map<String,Collection<ExportDataModel>> mapData);
  /**
   * 构建输出文件的Footer部分
   * @param efm 文件尾的内容
   */
  public void buildFooter(ExportFooterModel efm);
}
 
//	=================================== 生成器具体实现 - 文本 =======================================
 /**
  * 实现导出数据到文本文件的的生成器对象
  */
class TxtBuilder implements BuilderInterFace {
   /**
    * 用来记录构建的文件的内容，相当于产品
    */
   private StringBuffer buffer = new StringBuffer();

   public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
      for(String tblName : mapData.keySet()){
          //先拼接表名称
          buffer.append(tblName+"\n");
          //然后循环拼接具体数据
          for(ExportDataModel edm : mapData.get(tblName)){
             buffer.append(edm.getProductId()+","+edm.getPrice()+","+edm.getAmount()+"\n");
          }
      }
   }
   public void buildFooter(ExportFooterModel efm) {
      buffer.append(efm.getExportUser());
   }
   public void buildHeader(ExportHeaderModel ehm) {
      buffer.append(ehm.getDepId()+","+ehm.getExportDate()+"\n");
   }  
   public StringBuffer getResult(){
      return buffer;
   }   
}

//	================================== 具体实现 - XML ===========================================

/**
 * 实现导出数据到XML文件的的生成器对象
 */
class XmlBuilder implements BuilderInterFace {
  /**
   * 用来记录构建的文件的内容，相当于产品
   */
  private StringBuffer buffer = new StringBuffer();

  public void buildBody(Map<String, Collection<ExportDataModel>> mapData){
     buffer.append("  <Body>\n");
     for(String tblName : mapData.keySet()){
         //先拼接表名称
         buffer.append("    <Datas TableName=\""+tblName+"\">\n");
         //然后循环拼接具体数据
         for(ExportDataModel edm : mapData.get(tblName)){
            buffer.append("      <Data>\n");
            buffer.append("        <ProductId>"+edm.getProductId()+"</ProductId>\n");
            buffer.append("        <Price>"+edm.getPrice()+"</Price>\n");
            buffer.append("        <Amount>"+edm.getAmount()+"</Amount>\n");
            buffer.append("      </Data>\n");
         }
         buffer.append("    </Datas>\n");
     }
     buffer.append("  </Body>\n");
  }
  public void buildFooter(ExportFooterModel efm) {
     buffer.append("  <Footer>\n");
     buffer.append("    <ExportUser>"+efm.getExportUser()+"</ExportUser>\n");
     buffer.append("  </Footer>\n");
     buffer.append("</Report>\n");
  }
  public void buildHeader(ExportHeaderModel ehm) {
     buffer.append("<?xml version='1.0' encoding='gb2312'?>\n");
     buffer.append("<Report>\n");
     buffer.append("  <Header>\n");
     buffer.append("    <DepId>"+ehm.getDepId()+"</DepId>\n");
     buffer.append("    <ExportDate>"+ehm.getExportDate()+"</ExportDate>\n");
     buffer.append("  </Header>\n");
  }
  public StringBuffer getResult(){
     return buffer;
  }
}

//	===================================== 具体生成器 指导者 =================================

/**
 * 指导者，指导使用生成器的接口来构建输出的文件的对象
 */
class Director {
  /**
   * 持有当前需要使用的生成器对象
   */
  private BuilderInterFace builder;
  /**
   * 构造方法，传入生成器对象
   * @param builder 生成器对象
   */
  public Director(BuilderInterFace builder) {
     this.builder = builder;
  }

  /**
   * 指导生成器构建最终的输出的文件的对象
   * @param ehm 文件头的内容
   * @param mapData 数据的内容
   * @param efm 文件尾的内容
   */
  public void construct(
		  ExportHeaderModel ehm,
		  Map<String,Collection<ExportDataModel>> mapData,
		  ExportFooterModel efm) {
     //1：先构建Header
     builder.buildHeader(ehm);
     //2：然后构建Body
     builder.buildBody(mapData);
     //3：然后构建Footer
     builder.buildFooter(efm);
  }
}

