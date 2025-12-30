package com.example.sakana2.design
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BarBar(
    currentTab: String,
    onTabClick: (String) -> Unit
) {
    NavigationBar(
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = currentTab == "DeadlinesB",
            onClick = {onTabClick("DeadlinesB")},
            label = {Text("最近の予定", fontSize = 10.sp)},
            icon = {Icon(Icons.Default.List,contentDescription = null)}
        )

        NavigationBarItem(
            selected = currentTab == "SearchB",
            onClick = {onTabClick("SearchB")},
            label = {Text("検索", fontSize = 10.sp)},
            icon = {Icon(Icons.Default.Search,contentDescription = null)}
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {Spacer(Modifier.size(24.dp)) },
            enabled = false,
        )

        NavigationBarItem(
            selected = currentTab == "CalendarB",
            onClick = {onTabClick("CalendarB")},
            label = {Text("カレンダー",fontSize = 10.sp)},
            icon = {Icon(Icons.Default.DateRange,contentDescription = null)}
        )

        NavigationBarItem(
            selected = currentTab == "ProfileB",
            onClick = {onTabClick("ProfileB")},
            label = {Text("プロフィール", fontSize = 10.sp)},
            icon = {Icon(Icons.Default.AccountCircle,contentDescription = null)}
        )
    }
}

@Composable
fun BarHome(
    currentTab:String,
    onTabClick:(String) -> Unit,
    modifier:Modifier = Modifier
)   {
    FloatingActionButton(
        onClick = {onTabClick("HomeB")},
        shape = CircleShape,
        modifier = modifier.size(75.dp)
    ) {
        Icon(Icons.Filled.Add, null)
    }

}



            @Preview(showBackground = true)
            @Composable
            fun BarBarPreview() {
                BarBar(
                    currentTab = "aaaaa",
                        onTabClick = {}

                )

                BarHome(currentTab = "aaa",
                    onTabClick = {}
                    )

            }
