
package com.example.baitapdautien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baitapdautien.ui.theme.BaitapdautienTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaitapdautienTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042)
                ) {
                    ManHinhDanhThiep()
                }
            }
        }
    }
}

@Composable
fun ManHinhDanhThiep() {
    // Biến dữ liệu
    val tenDayDu = "Phạm Công Nghĩa"
    val chucDanh = "Lập trình viên Android"
    val soDienThoai = "+84 987 654 321"
    val lienHeSocial = "@nghiapc_dev"
    val diaChiEmail = "nghia.pc@email.com"

    // Bảng màu
    val mauNen = Color(0xFF073042)
    val mauDiemNhan = Color(0xFF3DDC84)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mauNen),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // PHẦN TRUNG TÂM: LOGO VÀ TÊN
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Đẩy phần liên hệ xuống đáy
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(110.dp)
                    .padding(8.dp)
            )

            Text(
                text = tenDayDu,
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
            )
            Text(
                text = chucDanh,
                color = mauDiemNhan,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = 1.5.sp
            )
        }

        // PHẦN DƯỚI: THÔNG TIN LIÊN HỆ
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp), // Khoảng cách với đáy màn hình
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Đường kẻ ngang mờ
            HorizontalDivider(
                modifier = Modifier.width(300.dp),
                thickness = 0.5.dp,
                color = Color.LightGray.copy(alpha = 0.3f)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Danh sách liên hệ
            ThanhPhanLienHe(icon = Icons.Rounded.Phone, noiDung = soDienThoai, mauIcon = mauDiemNhan)
            ThanhPhanLienHe(icon = Icons.Rounded.Share, noiDung = lienHeSocial, mauIcon = mauDiemNhan)
            ThanhPhanLienHe(icon = Icons.Rounded.Email, noiDung = diaChiEmail, mauIcon = mauDiemNhan)
        }
    }
}

@Composable
fun ThanhPhanLienHe(icon: ImageVector, noiDung: String, mauIcon: Color) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .width(280.dp), // Cố định chiều rộng để các icon thẳng hàng dọc
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = mauIcon,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = noiDung,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun XemTruocDanhThiep() {
    BaitapdautienTheme {
        ManHinhDanhThiep()
    }
}