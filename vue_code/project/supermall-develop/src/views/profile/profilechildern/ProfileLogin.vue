<template>
    <div id="profileLogin">
        <div class="profilePNL">
            <div class="info">
                <img src="../../../assets/img/profile/avatar.svg">
                <div class="loginDeali">
                    <div class="login">登录/注册</div>
                    <div class="phoneInfo">
                        <img src="../../../assets/img/profile/phone.svg">
                        暂未绑定手机号
                    </div>
                </div>
            </div>

            <div class="toLogin">
                >
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ProfileLogin"
    }
</script>

<style scoped>
    .profilePNL {
        display: flex;
        padding: 8px;
        background-color: #BDBCF0;
        justify-content: space-between;
    }

    .profilePNL img {
        width: 22%;
    }

    .info{
        display: flex;
    }

    .loginDeali {
        padding-left: 10px;
        padding-top: 20px;
        font-size: 16px;
        font-weight: 550;
        color: white;
    }

    .phoneInfo img {
        width: 30px;
        margin-left: -7px;
    }

    .phoneInfo {
        display: flex;
        height: 30px;
        line-height: 30px;
        /*background-color: red;*/
        margin-top: 10px;
    }

    .toLogin {
        display: flex;
        /*justify-content: center;*/
        align-items: center;
        font-size: 22px;
        color: white;
        margin-right: 10px;
        /*position: absolute;*/
        /*right: 20px;*/
        /*top: 80px;*/
    }
</style>