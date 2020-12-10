<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>假条处理</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!--
      1. 把数据列表当顶给表格data
      2. 设计表格列
      3. 给表格列绑定要渲染的数据字段
          -->
      <el-table
        class="table-list"
        :data="nodes"
        style="width: 100%"
        stripe
      >
        <el-table-column
          prop="offId"
          label="员工编号">
        </el-table-column>
        <el-table-column
          label="请假开始时间">
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row.offTime }}</span>
          </template>
        </el-table-column>
        <el-table-column
          label="请假结束时间">
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row.endTime }}</span>
          </template>
        </el-table-column>
        <el-table-column
          label="状态">
          <template slot-scope="scope">
            <el-tag
              :type="noteStatus[scope.row.ratified].type">
              {{ noteStatus[scope.row.ratified].text}}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              circle
              icon="el-icon-edit"
              @click="playNode(scope.row.id, scope.row.ratified)"
              type="primary"
            ></el-button>
          </template>
        </el-table-column>
      </el-table>
      <!--
       绑定页码
       绑定每页大小
       current-page 控制激活的页码，初始肯定是第 1 页
       page-sizes 控制可选的每页大小
      -->
      <!-- 列表分页 -->
      <el-pagination
        layout="prev, pager, next"
        :current-page.sync="page"
        :page-size="pageSize"
        :total="totalCount">
      </el-pagination>
    </el-card>
  </div>
</template>

<script>
  import { getAllNote, updateNotetype } from "@/api/personMan";

  export default {
  name: 'CommentIndex',
  props: {},
  components: {
  },
  data () {
    return {
      nodes: [], // 文章数据列表
      totalCount : 0,// 总数据条数
      pageSize : 10,
      page : 1,  // 当前激活的页码默认是1
      noteStatus: [
        { status: 0, text: '未批', type: 'info' }, // 0
        { status: 1, text: '已批', type: '' }, // 1
      ],
    }
  },
  computed: {
  },
  created() {
    this.loadNodes()
  },
  mounted() {},
  watch: {
  },
  methods: {
    handleSizeChange(val) {
      this.loadNodes(1, val)
    },
    handleCurrentChange(page) {
      // 页码给变 加载指定数据
      this.loadNodes(page)
    },
    loadNodes(page = 1){
      this.page = page
      getAllNote({
        curPage : page,
        limit : this.pageSize
      }).then(res => {
        this.nodes = res.data.page.list
        this.totalCount = res.data.page.totalCount
        console.log(this.nodes)
      })
    },
    playNode(noteId, ratified){
      this.$confirm('此操作将修改该状态, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        updateNotetype({
          id: noteId,
          ratified
        }).then(res => {
          this.$message({
            type : "success",
            message: "修改假条状态完成"
          })
          this.loadNodes()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
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
  .table-list{
    margin-bottom: 30px;
  }
</style>
