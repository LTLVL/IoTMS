<template>
    <div class="avue-sidebar" :style="'height:100%;background-color: #20222a;width:'+(isCollapse?'65px;':'201px;')">
        <!-- logo -->
        <div class="logo">
            <img src="../../../public/img/logo.png" />
            <div class="title" v-if="!isCollapse">暴富集团</div>
        </div>
        <!-- 左侧菜单 -->
        <el-menu
                unique-opened
                :default-active="active"
                class="el-menu-vertical-demo"
                background-color="#20222a"
                text-color="#fff"
                :collapse="isCollapse"
                style="height: calc(100% - 60px);overflow: auto;"
                active-text-color="#ffd04b">
            <router-link to="/home/index">
                <el-menu-item index="/home/index">
                    <i class="el-icon-menu"></i>
                    <span slot="title">首页</span>
                </el-menu-item>
            </router-link>

            <el-submenu index="user">
                <template slot="title">
                    <i class="el-icon-user-solid"></i>
                    <span slot="title">用户管理</span>
                </template>
                <el-menu-item-group>
                    <router-link to="/user/index">
                        <el-menu-item index="/user/index"><i class="el-icon-menu"></i>会员管理</el-menu-item>
                    </router-link>
                    <router-link to="/user/account">
                        <el-menu-item index="/user/account"><i class="el-icon-tickets"></i>账户管理</el-menu-item>
                    </router-link>
                    <router-link to="/user/fund">
                        <el-menu-item index="/user/fund"><i class="el-icon-orange"></i>资金管理</el-menu-item>
                    </router-link>
                </el-menu-item-group>
            </el-submenu>
            <router-link to="/business/index">
                <el-menu-item index="/business/index">
                    <i class="el-icon-help"></i>
                    <span slot="title">商家管理</span>
                </el-menu-item>
            </router-link>
            <router-link to="/product/index">
                <el-menu-item index="/product/index">
                    <i class="el-icon-menu"></i>
                    <span slot="title">商品管理</span>
                </el-menu-item>
            </router-link>
            <el-menu-item index="4">
                <i class="el-icon-s-grid"></i>
                <span slot="title">分类管理</span>
            </el-menu-item>
            <el-menu-item index="6">
                <i class="el-icon-coin"></i>
                <span slot="title">文件管理</span>
            </el-menu-item>
            <el-menu-item index="7">
                <i class="el-icon-notebook-2"></i>
                <span slot="title">日志管理</span>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
export default {
    name: "sidebarItem",
    data() {
        return {
            isCollapse: false,
            active: '/home/index',
        };
    },
    created() {
    },
    mounted() {
        let that = this;
        setInterval(function(){//定位当前菜单
            that.active = that.$router.currentRoute.path;
        },500);
    },
    computed: {
        nowTagValue() {
            return this.$router.path;
        }
    },
    methods: {
        changeCollapse(){
            this.isCollapse = !this.isCollapse;
            this.$emit('changeCollapse');
        },
        vaildActive(path) {
            // if (this.validIsOpen(item)) {
            //   return false;
            // }
            return this.nowTagValue === path;
        },
    }
};
</script>

<style>
.el-menu{
    border-right: none!important;
}
.is-active{

}
.avue-sidebar{
    padding-top: 0!important;
}
</style>