<template>
  <div class="header-container">
    <div>
      <i  :class="{
            'el-icon-s-fold' : isCollapse,
            'el-icon-s-unfold' : !isCollapse
          }"
          @click="changeCollapse"></i>
      <span>七里台男子职业技术学院</span>
    </div>
    <el-dropdown>
      <div class="avatar-wrap">
        <img class="avatar" src="https://edu-0906.oss-cn-beijing.aliyuncs.com/11.jpg" alt="">
        <span>{{user.username}}</span>
        <i class="el-icon-arrow-down el-icon--right"></i>
      </div>
          <!--
          组件默认不识别原生时间，除非默认做处理
          注意：并不是所有的组件在注册事件的时候需要使用 `.native` 修饰符，例如 el-button 组件注册点击事件就不需要，这主要是因为该组件内部处理了。

          什么时候使用 `.native`？首先肯定是在组件上注册事件可能会用到，如果普通方式注册不上，这个时候加 `.native` 修饰符。

          例如你给一个组件注册一个 `input` 事件，如果直接 `@input` 注册无效，那就试一下 `@input.native`。
          -->
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>设置</el-dropdown-item>
        <el-dropdown-item @click.native="onLogout">退出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
  import {getUserProfile} from "@/api/user";
  import globalBus from '@/utils/global-bus'

  export default {
    name: 'AppHeader',
    components: {},
    props: {},
    data () {
      return {
        user : {}, //当前登录用户信息
        isCollapse : false //用来控制侧边栏展开的
      }
    },
    computed: {},
    watch: {},
    created () {
      this.loadUserProfile()
      globalBus.$on('update-user', (data) => {
        // 因为 如果是对象的话 是引用类型
        // 虎相互影响 传字符串不会这样
        this.user.name = data.name
      })
    },
    mounted () {},
    methods: {
      // 除了登陆接口 其他所有接口 都需要授权才可以使用
      loadUserProfile(){
        const user = JSON.parse(window.localStorage.getItem('user'))
        if (user) {
          this.user = user
        }
      },
      changeCollapse(){
        this.isCollapse = !this.isCollapse
        this.$emit('LisenterChangeCollapse', this.isCollapse)
      },
      onLogout(){
        this.$confirm('确定退出吗?', '退出提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 把用户的登录状态清除
          window.localStorage.removeItem('user')
          // 跳转到登录页面
          this.$router.push('/login')
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消退出'
          })
        })
      }
    }
  }
</script>

<style scoped lang="less">
  .header-container {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid #ccc;
    .avatar-wrap {
      display: flex;
      align-items: center;
      .avatar {
        width: 30px;
        height: 30px;
        border-radius: 50%;
        margin-right: 10px;
      }
    }
  }
</style>
