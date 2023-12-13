<template>
    <div style="width: 100%;height: 100%;">
        <div style="display: flex;width: 100%;height: 100%;overflow: hidden;">
            <left ref="left"></left>
            <div :style="'width: calc(100% - '+(isCollapse?'65px':'200px')+');background-color: #f0f2f5;'">
                <top @changeCollapse="changeCollapse"></top>
                <tags/>
                <!-- 页面展示容器 -->
                <keep-alive>
                    <router-view class="vue-view" v-if="$route.meta.keepAlive"/>
                </keep-alive>
                <router-view class="vue-view" v-if="!$route.meta.keepAlive"/>
            </div>
        </div>

    </div>
</template>

<script>
import top from "../top/index.vue";
import left from "../left/index";
import tags from "./tags";

export default {
    components: {
        top,
        left,
        tags
    },
    name: "index",
    data() {
        return {
            loading: true,
            isCollapse: false,
            activeIndex: '1',
            activeIndex2: '1'
        };
    },
    mounted() {
    },
    methods: {
        changeCollapse(){
            console.info(this.isCollapse);
            this.isCollapse = !this.isCollapse;
            this.$refs.left.changeCollapse();
        }
    }
};
</script>

<style>
.vue-view{
    padding: 0 10px 0 10px!important;
    width: 100%!important;
    -webkit-box-sizing: border-box!important;
    box-sizing: border-box!important;
    background-color: #f0f2f5!important;
}
</style>