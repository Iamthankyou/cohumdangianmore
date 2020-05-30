# cohumdangianmore
Phiên bản cờ hùm dân gian mở rộng, làm trên Java AWT Swing, mở rộng chức năng lưu vào Database
# Lập trình trò chơi Cờ Hùm Tôm dân gian sử dụng Java AWT Swing
I. Cơ sở đề tài:

Trong xã hội hiện đại có nhiều hình thức giải trí khác nhau, phổ biến nhất với giới trẻ là thể thao điện tử, không tìm thấy trên Internet những trò chơi dân gian ngày xưa, nhóm em quyết định làm lại trò chơi Cờ Hùm Ăn Tôm phiên bản có thể chơi được trên các loại máy tính.

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





        


3.2 Tiếp theo là màn hình chọn quân điều khiển:





















3.3. Màn hình chính hiển thị trò chơi:











































3.4. Và màn hình kết thúc trò chơi:



























4. Ngoài 4 màn hình chơi chính, có thêm màn hình mở trò chơi đã lưu, màn hình lưu trò chơi.

5. Thanh công cụ gồm một thanh menu và taskbar như được hiển thị khi bắt đầu vào game như các hình ảnh trên.

6. Tính năng trò chơi:
Trò chơi có một số chức năng cần thiết như hiển thị lượt quân nào đang được phép đánh, thao tác undo, redo, thao tác lưu game khi trở về màn hình chính. 









IV. Thiết kế trò chơi:

Với game Cờ Hùm Dân Gian phiên bản offline, nhóm em triển khai theo mô hình lập trình hướng đối tượng OOP. Gồm 41 class phân chia thành từng tầng và nhiệm vụ khác nhau. 





1


1.Tư tưởng chính để thiết kế hệ thống: Design Pattern
Mô hình chính áp dụng trong hệ thống để hiển thị và xử lý trò chơi là MVC, áp dụng Obserse Pattern, MVC Pattern và Singleton Pattern.


Controller có nhiệm vụ xử lý và request mapping đến View. Khi Model thay đổi, ngay lập tức được thông báo để cập nhật lại view.

Cài đặt Observable dựa trên khóa Design Pattern Coursera:

Model sẽ extends Observable, add Observer là View, còn View sẽ implement Observer chỉ có một phương thức duy nhất là update() lại phần hiển thị, nếu muốn phần nào được cập nhật lại trong dữ liệu chính, chỉ cần thêm phương thức notifier() thông báo choObesrvable.

2. Để tránh khởi tạo nhầm hay khởi tạo lại class Model trong trò chơi của bọn em là ElementsManager, bọn em dùng Singleton Pattern để ngăn chặn gọi hàm khởi tạo trực tiếp từ bên ngoài, và chỉ cho phép khởi tạo lại khi cần thiết.


 













3. Tổng quan kiến trúc Trò chơi:


Trong xã hội hiện đại ngày càng phát triển, để tái hiện lại tuổi thơ ngày xưa, không tìm thấy một trò chơi Cờ Hùm trên Internet. Mình quyết định thử xây dựng một ứng dụng tương tự phiên bản dân gian ngày xưa từng chơi, giữ nguyên luật chơi nhưng tái hiện lại quân một cách sống động hơn.

# Xây dựng trò chơi

  - Trò chơi Cờ Hùm Tôm Dân Gian được viết bằng ngôn ngữ Java, sử dụng Java Swing.
  - Viết theo hướng OOP.

Trò chơi Cờ Hùm Tôm Dân Gian có hai chế độ chơi người với máy và người với người. Màn hình hiển thị bao gồm:

> Chọn quân chơi, quân được chọn sẽ đi trước.
> Chọn chế độ chơi, chơi với máy hoặc chơi với người khác.
> Màn hình hiển thị trò chơi.
> Màn hình kết thúc.
> Ngoài ra còn có thanh điều hướng, trở về màn hình chính, thao tác undo/redo.

### Một số hình ảnh Trò chơi Cờ Hùm Dân Gian 


![Màn hình bắt đầu](https://github.com/Iamthankyou/cohumdangian/blob/master/ImageDemo/Screenshot%20(70).png?raw=true)

![Màn hình bắt đầu](https://github.com/Iamthankyou/cohumdangian/blob/master/ImageDemo/Screenshot%20(71).png?raw=true)

![Màn hình bắt đầu](https://github.com/Iamthankyou/cohumdangian/blob/master/ImageDemo/Screenshot%20(72).png?raw=true)

![Màn hình bắt đầu](https://github.com/Iamthankyou/cohumdangian/blob/master/ImageDemo/Screenshot%20(73).png?raw=true)

Cảm ơn !
