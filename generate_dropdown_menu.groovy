import groovy.json.JsonSlurper

// 定义 JSON 文件的路径
def jsonFilePath = 'dropdown_list.json'

// 创建一个 JsonSlurper 实例来解析 JSON
def slurper = new JsonSlurper()

// 读取文件
def file = new File(jsonFilePath)
if (!file.exists()) {
    return ["Error: File not found"] // 如果文件不存在，返回错误信息
}

// 解析 JSON 文件
def data = slurper.parseText(file.text)

// 收集所有的名称作为下拉菜单的选项
def choices = data.collect { it.name }

return choices
