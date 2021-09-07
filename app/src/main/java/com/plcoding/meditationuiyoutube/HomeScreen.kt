package com.plcoding.meditationuiyoutube


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.ui.theme.*


@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {

        Column {
            Header("Okezino")
            MedList(chip = listOf("Sweet sleep", "Insomnia", "depression"))
            GetPlay()






            FeatureList(
                feature = listOf(
                    Feature(
                        title = "Sweet Meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night Island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming Sound",
                        R.drawable.ic_videocam,
                        Beige1,
                        Beige2,
                        Beige3

                    )
                    ,
                    Feature(
                        title = "Night Island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming Sound",
                        R.drawable.ic_videocam,
                        Beige1,
                        Beige2,
                        Beige3

                    )
                )
            )


            BottomMenu(
                list = listOf(
                    BottomMenuContent("Home", R.drawable.ic_home),
                    BottomMenuContent("Meditate", R.drawable.ic_bubble),
                    BottomMenuContent("Sleep", R.drawable.ic_moon),
                    BottomMenuContent("Music", R.drawable.ic_music),
                    BottomMenuContent("Profile", R.drawable.ic_profile)
                )
            )

        }




    }

}

@Composable
fun Header(
    name: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning!!  $name",
                style = MaterialTheme.typography.h2, color = TextWhite
            )

            Text(
                text = "Thanks Misha for a Wonderful UI",
                style = MaterialTheme.typography.body1, color = TextWhite
            )
        }

        Icon(
            painter = painterResource(R.drawable.ic_search), contentDescription = "Search",
            tint = TextWhite, modifier = Modifier.size(24.dp)
        )


    }

}

@Composable
fun MedList(
    chip: List<String>
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chip.size) {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedIndex == it) ButtonBlue else DarkerButtonBlue
                    ), contentAlignment = Alignment.Center
            ) {
                Text(text = chip[it], modifier = Modifier.padding(15.dp), color = Color.White)
            }
        }

    }
}

@Composable
fun GetPlay() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 2.dp, bottom = 15.dp)
            .clip(
                RoundedCornerShape(15.dp)
            )
            .background(LightRed)
    ) {

        Column() {
            Text(text = "Daily Thought", color = TextWhite, fontWeight = FontWeight.Bold, modifier = Modifier.padding(6.dp))
            Text(text = "Meditation . 3-10Min", color = TextWhite,
                modifier = Modifier.padding(6.dp), fontWeight = FontWeight.Bold)

        }
        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Red)
                .clip(RoundedCornerShape(15.dp))
                .size(30.dp), contentAlignment = Alignment.Center
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "player", tint = Color.White,
                modifier = Modifier.size(15.dp)
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun FeatureList(feature: List<Feature>) {

    Column(modifier = Modifier.fillMaxHeight(0.82f)) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),modifier = Modifier.fillMaxHeight(),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp)
        ) {
            items(feature.size) {

                Features(feature = feature[it])
            }
        }
    }
}


@Composable
fun Features(feature: Feature) {

    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title, style = MaterialTheme.typography.h1, lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Icon(
                painter = painterResource(id = feature.iconId), contentDescription = feature.title,
                tint = Color.White, modifier = Modifier.align(Alignment.BottomStart)
            )

            Text(
                text = "Start", fontSize = 14.sp, color = Color.White,
                fontWeight = FontWeight.Bold, modifier = Modifier
                    .clickable {
                        // do Something
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Blue)
                    .align(Alignment.BottomEnd)
                    .padding(vertical = 6.dp, horizontal = 6.dp)
            )
        }

    }
}

@Composable
fun BottomMenu(
    list: List<BottomMenuContent>,
    selectedItemIndex: Int = 0,
    modifier: Modifier = Modifier,
    selectedItemTextColor: Color = TextWhite,
    SelectedItemBackgroundColour: Color = Color.Blue,
    unSelectedItemBackgroundColor: Color = AquaBlue
) {
    var selectedItem by remember {
        mutableStateOf(selectedItemIndex)
    }

    Row(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
            .background(DeepBlue),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

    ) {

        list.forEachIndexed { index, bottomMenuContent ->

            BottomItem(item = bottomMenuContent, isSelected = index == selectedItem, selectedItemTextColor = selectedItemTextColor,
            unSelectedItemBackgroundColor = unSelectedItemBackgroundColor,SelectedItemBackgroundColour = SelectedItemBackgroundColour) {

                selectedItem = index

            }


        }


    }
}

@Composable
fun BottomItem(
    item: BottomMenuContent,
    SelectedItemBackgroundColour: Color = Color.Blue,
    unSelectedItemBackgroundColor: Color = AquaBlue,
    isSelected: Boolean = false,
    selectedItemTextColor: Color = TextWhite,
    onItemClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (isSelected) SelectedItemBackgroundColour else Color.Transparent
                )
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint =
                if (isSelected) selectedItemTextColor else unSelectedItemBackgroundColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Text(
            text = item.title,
            color = if (isSelected) selectedItemTextColor else unSelectedItemBackgroundColor
        )


    }

}