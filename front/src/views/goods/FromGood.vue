<template>
    <div class="FromGood">
        <el-form :model="goodFrom" :rules="ruleGood" ref="goodFrom" label-width="120px" class="demo-ruleForm">
            <el-form-item label="产品名称" prop="name">
                <el-input v-model="goodFrom.name" placeholder="请输入名称"></el-input>
            </el-form-item>
            <el-form-item label="产品描述" prop="name">
                <el-input v-model="goodFrom.name" placeholder="请输入产品描述"></el-input>
            </el-form-item>
            <el-form-item label="产品分类" prop="region">
                <el-select v-model="goodFrom.region" placeholder="请选择产品分类">
                    <el-option label="区域一" value="shanghai"></el-option>
                    <el-option label="区域二" value="beijing"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('goodFrom')">立即添加</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    data(){
        return {
            goodFrom:{
                pick: 8
            },
            ruleGood:{

            },
            dialogImageUrl: '',
            dialogVisible: false

        }
    },
    methods: {
        submitForm(){

        },
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        }
    }
}
</script>

<style scoped>
.FromGood{
    width: 100%;
    min-height: 100%;
    padding: 15px;
    box-sizing: border-box;
}
</style>