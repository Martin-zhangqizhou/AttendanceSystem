<template>
  <div class="upload-cover" @click="showCoverSelect">
    <div class="cover-wrap">
      <img
        class="cover-image"
        ref="cover-image"
        :src="value"
      >
    </div>

    <el-dialog
      title="选择封面"
      :visible.sync="dialogVisible"
      append-to-body
    >
      <el-tabs v-model="activeName" type="card">
        <el-tab-pane label="素材库" name="first">
          <image-list
            :is-show-add="false"
            :is-show-action="false"
            is-show-selected
            :foo="666"
            ref="image-list"
          />
        </el-tab-pane>
        <el-tab-pane label="上传图片" name="second">
          <input
            type="file"
            @change="onFileChange"
            ref="file"
          >
          <img
            width="100"
            ref="preview-image"
          >
        </el-tab-pane>
      </el-tabs>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button
          type="primary"
          @click="onCoverConfirm"
        >确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import ImageList from '@/views/image/components/image-list'
  import { uploadImage } from '@/api/image'
export default {
  name: 'UploadCover',
  props: ['value'],
  // props: ['cover-image'],
  components: {
    ImageList
  },
  data () {
    return {
      dialogVisible :false,
      activeName: 'second'
    }
  },
  computed: {
  },
  created() {},
  mounted() {},
  watch: {
  },
  methods: {
    showCoverSelect() {
      this.dialogVisible = true
    },
    onFileChange() {
      // 获取文件对象
      const file = this.$refs.file.files[0]
      const blob = window.URL.createObjectURL(file)
      this.$refs['preview-image'].src = blob
      //防止 用户选择同一个文件不触发change事件
      //this.$refs.file.value = ''
    },
    onCoverConfirm() {
      // 如果 tab 是上传图片，并且 input-file 有选择的文件，才执行上传图片的操作
      if (this.activeName === 'second') {
        const file = this.$refs.file.files[0]
        if (!file) {
          this.$message('请选择文件')
          return
        }
        // 执行上传文件的操作
        const fd = new FormData()
        fd.append('image', file)

        uploadImage(fd).then(res => {
          // 关闭弹出层
          this.dialogVisible = false
          // 展示上传的图片
          this.$refs['cover-image'].src = res.data.data.url

          // 将图片地址发送给父组件
          //this.$emit('update-cover', res.data.data.url)
          this.$emit('input', res.data.data.url)
          // this.$emit('update-cover', res.data.data.url)
        })
      }else if (this.activeName === 'first'){
        // 还有一种组件通信方式：父组件可以直接访问子组件中的数据
        const imageList = this.$refs['image-list']
        const selected = imageList.selected
        if (selected === null) {
          this.$message('请选择封面图片')
          return
        }

        // 关闭对话框
        this.dialogVisible = false
        // 修改父组件绑定数据
        this.$emit('input', imageList.images[selected].url)
      }
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
  .cover-wrap {
    width: 150px;
    height: 120px;
    border: 1px solid #000;
    .cover-image {
      height: 120px;
      max-width: 100%;
    }
  }
</style>
