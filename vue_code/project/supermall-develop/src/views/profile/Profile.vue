<template>
    <div id="profile">
        <nav-bar class="home-nav">
            <template v-slot:center>我的</template>
        </nav-bar>
        <profile-login/>
        <profile-info/>
        <profile-content/>
    </div>
</template>

<script>
    import NavBar from "../../components/common/navbar/NavBar";
    import ProfileLogin from "./profilechildern/ProfileLogin";
    import ProfileInfo from "./profilechildern/ProfileInfo";
    import ProfileContent from "./profilechildern/ProfileContent";

    export default {
        name: "Profile",
        components: {
            NavBar,
            ProfileLogin,
            ProfileInfo,
            ProfileContent
        }
    }
</script>

<style scoped>
    #profile {
        background-color: white;
    }
</style>