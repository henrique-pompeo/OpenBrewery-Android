package com.henrique.brewerylist.ui.fragment

import android.os.Bundle
import androidx.navigation.NavDirections
import com.henrique.brewerylist.R
import kotlin.Int
import kotlin.String

public class BreweryListFragmentDirections private constructor() {
  private data class ActionBreweryListFragmentToBreweryDetailFragment(
    public val id: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_breweryListFragment_to_breweryDetailFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("id", this.id)
      return result
    }
  }

  public companion object {
    public fun actionBreweryListFragmentToBreweryDetailFragment(id: String): NavDirections =
        ActionBreweryListFragmentToBreweryDetailFragment(id)
  }
}
