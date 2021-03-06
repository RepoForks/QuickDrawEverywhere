package com.tomer.draw.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.tomer.draw.R
import com.tomer.draw.utils.askDrawOverPermission
import com.tomer.draw.utils.askPermissionNoCallBack
import com.tomer.draw.utils.canDrawOverlaysCompat
import com.tomer.draw.utils.hasPermissions

/**
 * DrawEverywhere
 * Created by Tomer Rosenfeld on 7/29/17.
 */
class IntroFragment : BaseFragment(), View.OnClickListener {
	
	override fun onClick(v: View?) {
		when (v?.id) {
			R.id.permission_draw -> {
				activity.askDrawOverPermission()
			}
			R.id.permission_write_storage -> {
				activity.askPermissionNoCallBack(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
			}
			R.id.permission_read_storage -> {
				activity.askPermissionNoCallBack(android.Manifest.permission.READ_EXTERNAL_STORAGE)
			}
		}
	}
	
	override fun onResume() {
		super.onResume()
		if (activity.hasPermissions(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) && activity.canDrawOverlaysCompat())
			finish()
	}
	
	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		view?.findViewById<Button>(R.id.permission_draw)?.setOnClickListener(this)
		view?.findViewById<Button>(R.id.permission_read_storage)?.setOnClickListener(this)
		view?.findViewById<Button>(R.id.permission_write_storage)?.setOnClickListener(this)
	}
	
	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater?.inflate(R.layout.intro, container, false)
	}
}
