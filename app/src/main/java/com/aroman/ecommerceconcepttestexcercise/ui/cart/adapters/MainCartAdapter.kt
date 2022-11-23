package com.aroman.ecommerceconcepttestexcercise.ui.cart.adapters

import com.aroman.domain.model.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainCartAdapter(
    onPlusClicked: (position: Int) -> Unit,
    onMinusClicked: (position: Int) -> Unit,
    onDeleteClicked: (position: Int) -> Unit,
) : ListDelegationAdapter<List<DisplayableItem>>(
    cartAdapterDelegate(
        onPlusClicked,
        onMinusClicked,
        onDeleteClicked,
    )
)