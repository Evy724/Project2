package com.revature.project2.view.composables

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.coil.rememberCoilPainter
import com.revature.project2.R
import com.revature.project2.model.api.alltoys.ToyItem
import com.revature.project2.ui.theme.*
import com.revature.project2.view.nav.NavScreens
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import coil.transform.CircleCropTransformation
import com.revature.project2.MainActivity
import com.revature.project2.model.AppManager
import com.revature.project2.model.DataManager
import com.revature.project2.model.api.tradeoffers.TradeOffer
import com.revature.project2.viewmodel.AllToysViewModel

// Header for all screens
@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier
)
{
    Row(
        verticalAlignment = Alignment.CenterVertically
    )
    {

        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .semantics { heading() }
                .fillMaxWidth()
                .height(70.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            TealGreen,
                            Teal200
                        )
                    )
                )
        )
        {
            Image(
                painter = painterResource(id = R.drawable.toy_swap_logo),
                contentDescription = "Toy Swap Logo",
                alignment = Alignment.CenterStart,
                modifier = Modifier.padding(horizontal = 20.dp)
            )


            Text(
                text = text,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                style = Project2Typography.h6,
                modifier = Modifier.absolutePadding(left = 100.dp, top = 10.dp)
            )
        }

    }

}

@Composable
fun MainToyPosterImage()
{
    Image(
        painter = painterResource(id = R.drawable.toy_cover__1640___450_px_),
        contentDescription = "Main toy poster for whole app",
        modifier = Modifier
            .wrapContentWidth()
            .height(108.dp)
            .background(color = Color.Transparent),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun ToySwapLogo()
{
    Image(
        painter = painterResource(id = R.drawable.toy_swap_logo),
        contentDescription = "Logo for the Toy Swap app"
    )
}

@Composable
fun universalButton20sp(
    enabled: Boolean,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .background(
            brush = Brush.horizontalGradient(
                listOf(
                    TealGreen,
                    Teal200
                )
            ),
            shape = RoundedCornerShape(5.dp)
        ),
)
{
    Button(
        onClick = onClick,
        enabled = enabled,
        border = BorderStroke(
            5.dp,
            brush = Brush.horizontalGradient(
                listOf(
                    TealGreen,
                    Teal200
                )
            )
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.transparent),
        ),
        modifier = modifier
    )
    {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun previewUniversalButton()
{
    universalButton20sp(
        text = "wow",
        onClick = { /*TODO*/ },
        enabled = true,
    )
}
/**
 * Toy Display card
 *
 * button functionality not created yet
 */
@Composable
fun ToyCard(toy: ToyItem,bNotification:Boolean = false, onClick: () -> Unit)
{
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Purple200,
                        PurpleVariant
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable
            {
                onClick()
            }
            .clip(
                shape = RoundedCornerShape(10.dp)
            ),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface)
    {

        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        )
        {

            Image(
                painter = rememberCoilPainter(request = toy.sImagePath,),
                contentDescription = null,
                modifier = Modifier
                    .width(120.dp)
                    .height(100.dp)
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
                    .border(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                TealGreen,
                                BluishGreen
                            )
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ),
                contentScale = ContentScale.FillBounds
            )

            Spacer(Modifier.size(5.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Spacer(modifier = Modifier.height(10.dp))

                Text(toy.sName,
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center)

                Spacer(Modifier.size(5.dp))

                var poster = AppManager.getUserNameByID(toy.posterId) //toy.posterId

                Text(
                    text = "Added By: $poster",
                    style = MaterialTheme.typography.body1
                )
            }

        }
        Box(){
            if (bNotification)
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            }
        }
    }
}

/**
 * Bottom app bar for use between screens
 *
 * button functionality not created yet
 */
@Composable
fun BottomBar(navController: NavController, bConnected:Boolean = true)
{
    val selectedIndex = rememberSaveable { mutableStateOf(0) }
    BottomNavigation(
        elevation = 5.dp,
//        backgroundColor = MaterialTheme.colors.secondary,
//        modifier = Modifier.background(
//            Brush.horizontalGradient(
//                colors = listOf(
//                    TealGreen,
//                    Teal200
//                )
//            )
//        )
    )
    {
        
        BottomNavigationItem(
            selected = selectedIndex.value == 0,
            onClick = {

                if(bConnected) {
                    selectedIndex.value = 0
                    navController.navigate(NavScreens.BrowseItemsScreen.route)
                }
            },
            icon = { Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "")},
            label = {Text("Browse")}
        )

        BottomNavigationItem(
            selected = selectedIndex.value == 1,
            onClick = {

                if(bConnected) {
                    selectedIndex.value = 1
                    navController.navigate(NavScreens.PostedItemListScreen.route)
                }
            },
            icon = { Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "")},
            label = {Text("Post")}
        )

        BottomNavigationItem(
            selected = selectedIndex.value == 2,
            onClick = {
                if(bConnected) {
                    selectedIndex.value = 2
                    navController.navigate(NavScreens.ProfileScreen.route)
                }
            },
            icon = { Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "")},
            label = {Text("Profile")}
        )

    }
}

@Composable
fun ToyScaffold(sTitle:String,navController: NavController,  content:@Composable () -> Unit){

    Scaffold(
        topBar = { TopAppBar( title = {Text(sTitle)},
            backgroundColor = MaterialTheme.colors.secondary) },
        content =
        {
            content()
        },
        bottomBar =
        {
            BottomBar(navController)
        }
    )

}

@Composable
fun ToyCardWithButton(toy: ToyItem,buttonText:String, onClick:()->Unit)
{

    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(100.dp)
        .wrapContentHeight()
        .clickable { },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface)
    {

        Row(verticalAlignment = Alignment.Top)
        {

            Image(
                painter = rememberCoilPainter(
                    request = toy.sImagePath),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp),
                contentScale = ContentScale.Fit)

            Spacer(Modifier.size(5.dp))

            Column( modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {

                Text(toy.sName,
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center)

                Spacer(Modifier.size(2.dp))

                Text(text = toy.sDescription,
                    style = MaterialTheme.typography.body1)
            }
            Button(onClick = onClick)
            {
                Text(text = buttonText)
            }
        }

    }
}


@Composable
fun AcceptOrDeclineTradeOffersToyCard(
    navController: NavController,
    offer: TradeOffer
)
{
    val context = LocalContext.current
    val allToysVM = ViewModelProvider(context as MainActivity).get(AllToysViewModel::class.java)

    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(100.dp)
        .wrapContentHeight()
        .clickable { },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface)
    {

        Row(verticalAlignment = Alignment.Top)
        {
            val theirToy = allToysVM.getToyByID(id = offer.nOfferToyId)!!

            // Their toy
            Image(
                painter = rememberCoilPainter(
                    request = theirToy.sImagePath),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp),
                contentScale = ContentScale.Fit)

            val yourToy = allToysVM.getToyByID(id = offer.nUserToyId)!!
            // Your toy
            Image(
                painter = rememberCoilPainter(
                    request = yourToy.sImagePath),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp),
                contentScale = ContentScale.Fit)

            Spacer(Modifier.size(5.dp))

            Row()
            {
                universalButton20sp(
                    onClick =
                    {

                        Toast.makeText(context,"Trade accepted",Toast.LENGTH_LONG).show()
                        navController.popBackStack(NavScreens.BrowseItemsScreen.route,false)
                    },
                    enabled = true,
                    text = "Accept",
                )
                universalButton20sp(
                    onClick =
                    {
                        Toast.makeText(context,"Trade declined",Toast.LENGTH_LONG).show()
                        navController.popBackStack(NavScreens.BrowseItemsScreen.route,false)
                    },
                    enabled = true,
                    text = "Decline"
                )
            }
        }
    }
}
