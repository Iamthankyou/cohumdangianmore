I. Cơ sở đề tài:

Trong xã hội hiện đại có nhiều hình thức giải trí khác nhau, phổ biến nhất với giới trẻ là thể thao điện tử, không tìm thấy trên Internet những trò chơi dân 
gian ngày xưa, nhóm em quyết định làm lại trò chơi Cờ Hùm Ăn Tôm phiên bản có thể chơi được trên các loại máy tính.

II. Ngôn ngữ sử dụng:

Lập trình game Cờ Hùm Ăn Tôm trên ngôn ngữ Java với giao diện AWT Swing. Sử dụng IDE Eclipse và thư viện mysqlConnection phiên bản 8.0 để kết nối cơ cở dữ liệu.

III. Trò chơi
1. Luật chơi:
Trò chơi cờ hùm phiên bản gốc gồm có 2 người chơi, một bên chọn quân Hùm (3 quân), một bên chọn quân Tôm (17 quân bao gồm 1 Tôm Tướng), bàn cờ có thể tưởng tượng bao gồm một hình chữ nhật kích thước 7x5.

Luật chơi cụ thể: cả hai bên được đi tương tự nhau theo các vạch được kẻ sẵn trên bàn cờ, mỗi lần di chuyển 1 ô.

Hùm được ăn Tôm khi đứng cách Tôm 1 ô và ở giữa không có quân nào.
Chỉ có Tôm Tướng được ăn Hùm khi và chỉ khi ở giữa Tôm Tướng và Hùm là một Tôm Tốt.

Trò chơi kết thúc khi một trong hai bên hết quân.

2. Chế độ chơi:
Trò chơi cờ Hùm phiên bản máy tính gồm có 2 chế độ chơi, là chế độ chơi người với người và máy với máy.

Trong tương lai có thể mở rộng thêm chế độ chơi online giữa hai người với nhau trên các máy khác nhau.

3. Mô tả màn hình hiển thị trò chơi:

3.1 Màn hình khi mở trò chơi là màn hình chọn chế độ chơi:
![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/01.png?raw=true)

3.2 Tiếp theo là màn hình chọn quân điều khiển:

![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/02.png?raw=true)

3.3. Màn hình chính hiển thị trò chơi:



![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/03.png?raw=true)

3.4. Và màn hình kết thúc trò chơi:




![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/04.png?raw=true)


























4. Ngoài 4 màn hình chơi chính, có thêm màn hình mở trò chơi đã lưu, màn hình lưu trò chơi.

5. Thanh công cụ gồm một thanh menu và taskbar như được hiển thị khi bắt đầu vào game như các hình ảnh trên.

6. Tính năng trò chơi:
Trò chơi có một số chức năng cần thiết như hiển thị lượt quân nào đang được phép đánh, thao tác undo, redo, thao tác lưu game khi trở về màn hình chính. 

Tối ưu reponsive.







IV. Thiết kế trò chơi:
Với game Cờ Hùm Dân Gian phiên bản offline, nhóm em triển khai theo mô hình lập trình hướng đối tượng OOP. Gồm 41 class phân chia thành từng tầng và nhiệm vụ khác nhau. 

![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/05.png?raw=true)



1


1.Tư tưởng chính để thiết kế hệ thống: Design Pattern
Mô hình chính trong hệ thống để hiển thị và xử lý trò chơi là MVC, áp dụng Obserse Pattern, MVC Pattern và Singleton Pattern.
![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/06.png?raw=true)

Controller có nhiệm vụ xử lý và request mapping đến View. Khi Model thay đổi, ngay lập tức được thông báo để cập nhật lại view.

Cài đặt Observable dựa trên khóa Design Pattern Coursera:

![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/07.png?raw=true)

Model sẽ extends Observable, add Observer là View, còn View sẽ implement Observer chỉ có một phương thức duy nhất là update() lại phần hiển thị, nếu muốn phần nào được cập nhật lại trong dữ liệu chính, chỉ cầ
n thêm phương thức notifier() thông báo choObesrvable.

2. Để tránh khởi tạo nhầm hay khởi tạo lại class Model trong trò chơi của bọn em là ElementsManager, bọn em dùng Singleton Pattern để ngăn chặn gọi hàm khởi tạo trực tiếp từ bên ngoài, và chỉ cho phép khởi tạo lại khi cần thiết.

![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/08.png?raw=true)













3. Tổng quan kiến trúc Trò chơi:

Mô hình Model-Controller-View là nền tảng:
![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/09.png?raw=true)





















Đây là tầng dữ liệu động của trò chơi:
![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/10.png?raw=true)





Đây là tầng hiển thị trò chơi, button save và open chỉ đươc gọi khi cần thiết.
![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/11.png?raw=true)




Đây là tầng DAO, có nhiệm vụ giao tiếp với cơ sở dữ liệu.
![](https://github.com/Iamthankyou/cohumdangianmore/blob/master/Image/12.png?raw=true)




















Chế độ chơi với Âmáy sử dụng thuật toán Minimax để tìm kiếm bước tối ưu (Còn phát triển).




Xin chân thành cảm ơn !



Cảm ơn !
