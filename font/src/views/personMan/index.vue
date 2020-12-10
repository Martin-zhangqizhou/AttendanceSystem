<template>
  <div class="article-container">
    <el-card class="filter-card">
      <div slot="header" class="clearfix">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>内容管理</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <el-form ref="form" label-width="50px" size="mini">
        <el-form-item label="姓名">
          <el-input v-model="username"></el-input>
        </el-form-item>
        <el-form-item>
          <!--button按钮的 click事件有个默认参数
          当不指定参数时 会传递一个默认的没用的参数-->
          <el-button
            type="primary"
            @click="loadPerson(1)"
            :disabled="loading"
          >查询</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <!-- 数据列表 -->
    <!--
      Table 表格组件
      1、把需要展示的数组列表数据绑定给 table 组件的 data 属性
        注意：你不用去 v-for 遍历，它自己会遍历
      2、设计表格列 el-table-column
        width 可以设定表格列的宽度
        label 可以设定列的标题
        prop  用来设定要渲染的列表项数据字段，只能展示文本

      3、表格列默认只能渲染普通文本，如果需要展示其它内容，例如放个按钮啊、放个图片啊，那就需要自定义表格列模板了：https://element.eleme.cn/#/zh-CN/component/table#zi-ding-yi-lie-mo-ban
     -->

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        根据筛选条件共查询到 {{totalCount}} 条结果：
      </div>
      <!-- 数据列表 -->
      <el-table
        v-loading = "loading"
        :data="allPerson"
        stripe
        style="width: 100%"
        class="list-table"
        size="mini"
      >
        <el-table-column
          prop="userId"
          label="Id">
        </el-table-column>
        <el-table-column
          prop="username"
          label="姓名">
        </el-table-column>
        <el-table-column
          label="状态">
          <template slot-scope="scope">
            <el-tag
              :type="articleStatus[scope.row.status].type">
              {{ articleStatus[scope.row.status].text}}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="mobile"
          label="手机">
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              circle
              icon="el-icon-edit"
              @click="$router.push('/publish?id=' + scope.row.userId)"
              type="primary"
            ></el-button>
            <el-button
              size="mini"
              type="danger"
              icon="el-icon-delete"
              @click="onDeletePerson(scope.row.userId)"
              :hidden="scope.row.userId === 1"
              circle
            ></el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- /数据列表 -->

      <!-- 列表分页 -->
      <el-pagination
        @current-change="onCurrentChange"
        layout="prev, pager, next"
        background
        :current-page.sync="page"
        :disabled="loading"
        :page-size="pageSize"
        :total="totalCount">
      </el-pagination>
      <!-- /列表分页 -->
    </el-card>
  </div>
</template>

<script>
  import { getAllPerson, deletePerson } from '@/api/personMan'
export default {
  name: 'ArticleIndex',
  props: {},
  components: {
  },
  data () {
    return {
      username : null,
      articles: [],
      articleStatus: [
        { status: 0, text: '禁用', type: 'info' }, // 0
        { status: 1, text: '正常', type: '' }, // 1
      ],
      // axios 不会发送数据位null unefiened之类的数据
      totalCount : 0,
      pageSize : 20,
      loading : true, // 表单中数据加载中 loading
      page : 1, // 当前页码
      allPerson: []
    }
  },
  computed: {
  },
  created() {
    this.loadPerson(1)
  },
  mounted() {
  },
  watch: {
  },
  methods: {
    loadPerson (page = 1) {
      //展示加载中 loading
      this.loading = true
      this.$message({
        type: 'success',
        message : '查询成功'
      })
      getAllPerson({
        curPage : page ,
        limit : this.pageSize,
        username : this.username
      }).then(res => {
        this.totalCount = res.data.page.totalCount
        // 解构  前面是真正的数据名称 后面是我们定义的
        this.loading = false
        this.allPerson = res.data.page.list
      })
    },
    onCurrentChange(page) {
      this.loadPerson(page)
    },
    onDeletePerson(userId) {
      this.$confirm('确认删除吗？', '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 确认执行这里
        deletePerson(userId.toString()).then(res => {
          this.$message({
            message: '删除成功',
            type: 'success'
          })
          this.loadPerson(this.page)
        })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
  },
  filters: {
    fnName: function (value) {
      return value
    }
  }
}
</script>

<style scoped lang="less">
  .filter-card {
    margin-bottom: 30px;
  }

  .list-table {
    margin-bottom: 20px;
  }
</style>
