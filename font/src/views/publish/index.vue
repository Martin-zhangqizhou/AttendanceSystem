<template>
  <div class="publish-container">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <div slot="header" class="clearfix">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>{{ $route.query.id ? '修改信息': '添加人员'}}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
      </div>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="form.email"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="form.mobile"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-radio v-model="form.status" label="0">禁用</el-radio>
          <el-radio v-model="form.status" label="1">正常</el-radio>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onPublish">新增</el-button>
          <el-button type="primary" @click="onPublish">修改</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
  import { addPerson, getPerson, updatePerson } from "@/api/personMan"
  export default {
  name: 'PublishIndex',
  props: {},
  components: {
  },
  data () {
    return {
      form: {}
    }
  },
  computed: {
  },
  created() {
    // 由于我们让发布和修改使用的是 同一个组件
    // 所以这里要判断
    // 如果路由参数中有 id  则请求展示文章内容
    if (this.$route.query.id) {
      this.loadPerson()
    }
  },
  mounted() {},
  watch: {
  },
  methods: {
    onPublish() {
      if (this.userId){
        this.form.userId = this.userId
        updatePerson(this.form).then(res => {
          this.$message({
            message: `修改成功`,
            type: 'success'
          })
          // 跳转到内容管理页面
          this.$router.push('/personMan')
        })
      }else {
        addPerson(this.form).then(res => {
          this.$message({
            message: `新增成功`,
            type: 'success'
          })
          // 跳转到内容管理页面
          this.$router.push('/personMan')
        })
      }
    },
    loadPerson () {
      // 修改文章 加载文章内容
      this.userId = this.$route.query.id.toString()
      getPerson(this.userId).then(res => {
        const {email, username, mobile, status} = res.data.user
        this.form = {email, username, mobile, status}
      })
    },
  }
}
</script>

<style scoped lang="less">

</style>
