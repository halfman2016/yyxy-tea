package com.boteteam.yper.yyxy.Teacher

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import com.boteteam.yper.yyxy.Module.GradeClass
import com.boteteam.yper.yyxy.MyApplication
import com.boteteam.yper.yyxy.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.listitem_main_assignbz.view.*
import kotlinx.android.synthetic.main.teassignchoosegc.*

class teaAssignChooseGc() : AppCompatActivity(),View.OnClickListener {


    private var myapplication=MyApplication.getInstance();
    private var teacher=myapplication.teacher
    private var gcs=myapplication.gcsubjects
    private var selgcs= arrayListOf<GradeClass>()

    constructor(parcel: Parcel) : this() {

    }
    //教授班级，教授科目

    override fun onClick(p0: View?) {
        var checks= arrayListOf<CheckBox>()

         when (p0) {
            is CheckBox -> {

                var b: CheckBox = p0
                Log.d("myapp", b.text.toString())
            }
            is Button -> {

                var i = 0
                while (i < checkboxs.childCount) {
                    var ch = checkboxs.getChildAt(i) as CheckBox
                    if (ch.isChecked) {
                        gcs.containsValue(ch.text)
                    }
                    i++
                }
                Log.d("myapp", checks.toString())
                Log.d("myapp", checkboxs.childCount.toString())

                var intent=Intent();
                intent.setClass(this,teaAssignAssign::class.java);
                var gson=GsonBuilder().create();
                var gcstr:String=""
                for(gc in gcs)
                {
                    gcstr=gson.toJson(gc.key)
                }
                intent.putExtra("gclasses",gcstr)
                startActivity(intent)
            }

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teassignchoosegc)
        btngchoosenext.setOnClickListener(this)
        loaddata()
    }
    fun loaddata(){

        for (gc in gcs)
        {
            var checkBox=CheckBox(this);
            checkBox.text=gc.key.name + ":" + gc.value
            checkBox.setOnClickListener(this)
            checkboxs.addView(checkBox)

        }
    }



}
