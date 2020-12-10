<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="假期开始">
      <el-col :span="11">
        <el-date-picker
          type="date"
          placeholder="选择日期"
          v-model="form.offTime"
          format="yyyy-MM-dd"
          value-format="yyyy-MM-dd"
          style="width: 100%;"
        ></el-date-picker>
      </el-col>
    </el-form-item>
    <el-form-item label="假期结束">
      <el-col :span="11">
        <el-date-picker
          type="date"
          placeholder="选择日期"
          format="yyyy-MM-dd"
          value-format="yyyy-MM-dd"
          v-model="form.offEnd"
          style="width: 100%;"
        ></el-date-picker>
      </el-col>
    </el-form-item>
    <el-form-item label="请假理由">
      <el-input type="textarea" v-model="form.desc"></el-input>
    </el-form-item>
    <el-form-item label="请假天数">
      <el-input-number
        v-model="form.offDays"
        :min="1"
        :max="365"
        label="描述文字"
      ></el-input-number>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">提交审核</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import {subimitNote} from '@/api/personMan'
export default {
  name: 'workerIndex',
  props: {},
  components: {
  },
  data() {
    return {
      form: {
        offTime: "",
        offEnd: "",
        offDays: "",
        desc: "",
        workerId : "",
        id : 1
      },
      num: 1
    };
  },
  computed: {
  },
  created() {},
  mounted() {},
  watch: {
  },
  methods: {
    onSubmit() {
      const user = JSON.parse(window.localStorage.getItem('user'))
      this.form.workerId = user.workerId
      subimitNote(this.form).then(res => {
        if (res.data.code === 201){
          this.$message({
            type : "warning",
            message : res.data.msg
          })
        }else{
          this.$message({
            type : "success",
            message : res.data.message
          })
        }
      })
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

</style>
