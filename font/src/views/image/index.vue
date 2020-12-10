<template>
  <div class="image-container">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <!-- 面包屑路径导航 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
          <el-breadcrumb-item>素材管理</el-breadcrumb-item>
          <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
        </el-breadcrumb>
        <!-- /面包屑路径导航 -->
      </div>
      <image-list/>
    </el-card>
  </div>
</template>

<script>
  import ImageList from "./components/image-list";
export default {
  name: 'ImageIndex',
  props: {},
  components: {
    ImageList
  },
  data () {
  },
  computed: {
  },
  created() {
  },
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
  /*.action-head{*/
  /*  padding-bottom: 30px;*/
  /*  display: flex;*/
  /*  justify-content: space-between;*/
  /*}*/

  /*.image-item {*/
  /*  position: relative;*/
  /*}*/

  /*.image-action{*/
  /*  font-size: 25px;*/
  /*  display: flex;*/
  /*  justify-content: space-evenly;*/
  /*  align-items: center;*/
  /*  color: #fff;*/
  /*  height: 40px;*/
  /*  background-color: rgba(204, 204, 204, .5);*/
  /*  position: absolute;*/
  /*  bottom: 4px;*/
  /*  left: 10px;*/
  /*  right: 10px;*/
  /*}*/
</style>
