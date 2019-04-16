package com.frame.mvp.common.bean

data class PageModel(
    var pageNumber: Int = 0,
    var totalRow: Int = 0,
    var pageSize: Int = 0,
    var totalPage: Int = 0
)
