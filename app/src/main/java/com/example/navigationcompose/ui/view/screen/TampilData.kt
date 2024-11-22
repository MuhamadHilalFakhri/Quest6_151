package com.example.navigationcompose.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.model.RencanaStudi

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.R

@Composable
fun TampilView(
    mahasiswa: Mahasiswa,
    krs: RencanaStudi,
    onBackButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.umy),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)
            )

            Spacer(modifier = Modifier.padding(start = 16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = mahasiswa.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White
                )
                Text(
                    text = mahasiswa.nim,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = Color.White
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.primary)),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = "Data Mahasiswa",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(16.dp)
            ) {
                Column {
                    Text(text = "Informasi Mahasiswa", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "NIM: " + mahasiswa.nim)
                    Text(text = "Nama: " + mahasiswa.nama)
                    Text(text = "Email: " + mahasiswa.email)
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Rencana Studi", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Mata Kuliah: " + krs.namaMK)
                    Text(text = "Kelas: " + krs.kelas)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { onBackButtonClicked() }) {
                    Text(text = "Back")
                }
                Button(onClick = { onNextButtonClicked() }) {
                    Text(text = "Halaman Utama")
                }
            }
        }
    }
}

