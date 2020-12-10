<template>
  <div>
    <h1>首页</h1>
    <div id="container"></div>
  </div>
</template>

<script>
export default {
  // 指定name的选项是 有助于 调试
  name: 'homeIndex',
  components: {
  },
  data () {
    return {

    }
  },
  computed: {
  },
  created() {},
  mounted() {
    var map = new window.BMapGL.Map("container");
    var point = new window.BMapGL.Point(116.404, 39.915);
    map.centerAndZoom(point, 15);
  },
  watch: {
  },
  methods: {
  },
}
</script>

<style scoped lang="less">

</style>
