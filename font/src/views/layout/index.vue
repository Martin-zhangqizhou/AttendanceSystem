<template>
  <el-container class="layout-container">
    <el-aside class="aside"
              width="auto">
      <AppAside class="aside-menu"
                :is-collapse="isCollapse"
      ></AppAside>
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
  import AppAside from './components/aside'
  import AppHeader from './components/herader'
export default {
  name: '',
  props: {},
  components: {
    AppAside,
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
</style>
