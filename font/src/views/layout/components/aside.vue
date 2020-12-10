<template>
  <!--
  el-menu-item 的 index 不能重复，确保唯一即可
 -->
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
    <el-menu-item index="/personMan">
      <i class="el-icon-document"></i>
      <span slot="title">人员管理</span>
    </el-menu-item>
    <el-menu-item index="/publish">
      <i class="iconfont iconpublish"></i>
      <span slot="title">添加人员</span>
    </el-menu-item>
    <el-menu-item index="/comment">
      <i class="iconfont iconcomment"></i>
      <span slot="title">假条管理</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: 'AppAside',
  props: ['is-collapse'],
  components: {
  },
  data () {
    return {
    }
  },
  computed: {
  },
  created() {},
  mounted() {},
  watch: {
  },
  methods: {

  },
  filters: {
    fnName: function (value) {
      return value
    }
  }
}
</script>

<style scoped lang="less">
  .nav-menu{
    .iconfont{
      margin-right: 9px;
      padding-left: 5px;
    }
  }
</style>
