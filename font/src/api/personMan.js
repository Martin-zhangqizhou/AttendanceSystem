/**
 * 文章相关请求模块
 */

import request from "@/utils/request";

/**
 * 获取文章列表
 */
export const getArticles = params => {
  return request({
    method: 'GET',
    url: '/mp/v1_0/articles',
    // Body 参数使用 data 设置
    // Query 参数使用 params 设置
    // Headers 参数使用 headers 设置
    params
  })
}


/**
 * 编辑文章
 */
export const updateArticle = (articleId, data, draft = false) => {
  return request({
    method: 'PUT',
    url: `/mp/v1_0/articles/${articleId}`,
    params: {
      draft // 是否存为草稿（true 为草稿）
    },
    data
  })
}

/**
 * 获取指定文章
 */
export const getArticle = articleId => {
  return request({
    method: 'GET',
    url: `/mp/v1_0/articles/${articleId}`
  })
}

/**
 * 修改文章评论状态
 */
export const updateCommentStatus = (articleId, allowComment) => {
  return request({
    method: 'PUT',
    url: '/mp/v1_0/comments/status',
    params: {
      // 对象的属性名不受代码规范限制
      article_id: articleId
    },
    data: {
      allow_comment: allowComment
    }
  })
}


export const getAllPerson = params => {
  return request({
    method: 'GET',
    // 接口文档中的写的路径参数需要在 url 中传递
    // 凡是看见接口路径中有的 :xxx 格式的字段，则需要传递路径参数
    url: '/attendsys/sys/user/list',
    params
  })
}
export const deletePerson = userId => {
  return request({
    method: 'POST',
    // 接口文档中的写的路径参数需要在 url 中传递
    // 凡是看见接口路径中有的 :xxx 格式的字段，则需要传递路径参数
    url: `/attendsys/sys/user/delete/`,
    params : {
      userId: userId
    }
  })
}


/**
 * 新建文章
 */
export const addPerson = (data) => {
  return request({
    method: 'POST',
    url: '/attendsys/sys/user/save/',
    data
  })
}

/**
 * 获取指定文章
 */
export const getPerson = userId => {
  return request({
    method: 'GET',
    url: `/attendsys/sys/user/info/${userId}`
  })
}


/**
 * 编辑文章
 */
export const updatePerson = (data) => {
  return request({
    method: 'POST',
    url: `/attendsys/sys/user/update`,
    data
  })
}


/**
 * 查看所有假条
 */
export const getAllNote = (params) => {
  return request({
    method: 'GET',
    url: `/attendsys/worker/mangerapprove/list`,
    params
  })
}

/**
 * 查看所有假条
 */
export const updateNotetype = (params) => {
  return request({
    method: 'GET',
    url: `/attendsys/worker/mangerapprove/ratify`,
    params
  })
}


/**
 * 查看所有假条
 */
export const subimitNote = (data) => {
  return request({
    method: 'POST',
    url: `/attendsys/worker/offnote/off`,
    data
  })
}
