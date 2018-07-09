# Auto-Screenshot-Java

+ `/core`截图核心代码
+ `/gui`客户端UI

pdf自动截图粗糙的demo。

原理是输入截图区域的x坐标，y坐标，宽，高，图片类型、保存位置、截图次数之后。

调用Robot类的截图和page down。

然后将截图的文件存到指定位置。

## 不足

+ 需要手动确认坐标。
+ Start之后需要手动点击pdf，否则将无法翻页。