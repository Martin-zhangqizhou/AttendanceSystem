<template>
  <el-container class="layout-container">
    <el-aside class="aside"
              width="auto">
      <el-menu
        :collapse = 'isCollapse'
        class="nav-menu"
        router
        :default-active="$route.path"
        background-color="#002033"
        text-color="#fff"
        active-text-color="#ffd04b">
        <br>
        <el-menu-item index="/">
          <i class="el-icon-s-home"></i>
          <span slot="title">首页</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header class="header">
        <AppHeader @LisenterChangeCollapse = "changeCollapse"></AppHeader>
      </el-header>
      <el-main class="main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import AppHeader from './components/herader'
export default {
  name: '',
  props: {},
  components: {
    AppHeader
  },
  data () {
    return {
      isCollapse : false
    }
  },
  computed: {
  },
  created() {
  },
  mounted() {},
  watch: {
  },
  methods: {
    changeCollapse(){
      this.isCollapse = !this.isCollapse
    }
  },
  filters: {
    fnName: function (value) {
      return value
    }
  }
}
</script>

<style scoped lang="less">
  .layout-container {
    position: fixed;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
  }
  .aside{
    background-color: #d3dce6;
    .aside-menu{
      height: 100%;
    }
  }
  .main {
    background-color: #e9eef3;
  }

  .nav-menu{
    .iconfont{
      margin-right: 9px;
      padding-left: 5px;
    }
  }
</style>
