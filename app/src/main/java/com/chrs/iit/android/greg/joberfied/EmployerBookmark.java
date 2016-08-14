package com.chrs.iit.android.greg.joberfied;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import jp.wasabeef.richeditor.RichEditor;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmployerBookmark extends Fragment implements View.OnClickListener {


    public EmployerBookmark() {
  // Required empty public constructor
    }

    RichEditor editor;
    TextView editor_preview;
    Spinner spinner_commission_createAds,spinner_values_createAds,spinner_commission_postVideo,spinner_value_postVideo;
    Button btn_createAds,btn_linkvideo,btn_postjob,btn_submitPostAd;
    ExpandableRelativeLayout expandableRelativeLayout_ads,expandableRelativeLayout_video,expandableRelativeLayout_job;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
     Bundle savedInstanceState) {
  // Inflate the layout for this fragment
  final View view= inflater.inflate(R.layout.fragment_employer_bookmark, container, false);

  btn_createAds=(Button)view.findViewById(R.id.btn_expand_createads);
  btn_createAds.setOnClickListener(this);
  btn_linkvideo=(Button)view.findViewById(R.id.btn_expand_linkvideo);
  btn_linkvideo.setOnClickListener(this);
  btn_postjob=(Button)view.findViewById(R.id.btn_expand_postjob);
  btn_postjob.setOnClickListener(this);
  btn_submitPostAd=(Button)view.findViewById(R.id.btn_createAds_postAds);
  btn_submitPostAd.setOnClickListener(this);
  expandableRelativeLayout_ads=(ExpandableRelativeLayout)view.findViewById(R.id.expandLayout_createads);
  expandableRelativeLayout_video=(ExpandableRelativeLayout)view.findViewById(R.id.expandLayout_linkvideo);
  expandableRelativeLayout_job=(ExpandableRelativeLayout)view.findViewById(R.id.expandLayout_postjob);
//---Rich Editor---------------------------------------------------------------------------------------
        editor=(RichEditor)view.findViewById(R.id.editor);
   // editor_preview=(TextView)view.findViewById(R.id.editor_preview);

        editor.setEditorHeight(100);
        editor.setEditorFontSize(22);
        editor.setEditorBackgroundColor(Color.WHITE);
         //editor.setPadding(10, 10, 10, 10);
        editor.setPlaceholder("Insert here");
        editor.setOnTextChangeListener(new RichEditor.OnTextChangeListener() {
            @Override public void onTextChange(String text) {
                //editor_preview.setText(text);
            }
        });
    RichEditor(view);

        //----Spinner ADS---------------------------------------------------------------------------------------
        spinner_commission_createAds=(Spinner)view.findViewById(R.id.spinner_createAds_Commission);
        String[] createAds_commissionItems=new String[]{"   ","TEST 1","TEST 2","TEST 3"};
        ArrayAdapter<String>adapter_createAds_commission=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,createAds_commissionItems) {
            @Override
            public boolean isEnabled(int position) {
               if(position==0){
                   return false;
               }
                else {
                   return true;
               }

            }

        };
        spinner_commission_createAds.setAdapter(adapter_createAds_commission);
        spinner_commission_createAds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_values_createAds=(Spinner)view.findViewById(R.id.spinner_createAds_Value);
        String []createAds_valuesItems=new String[]{"   ","TEST 1","TEST 2","TEST 3"};
        ArrayAdapter<String>adapter_createAds_values=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,createAds_valuesItems) {
            @Override
            public boolean isEnabled(int position) {
                if(position==0){
                    return  false;
                }
                else {
                    return true;
                }
            }

        };
        spinner_values_createAds.setAdapter(adapter_createAds_values);
        spinner_values_createAds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //---------------------------------------------------------------------------------------------------------

        //-----Spinner Video---------------------------------------------------------------------------------------
        spinner_commission_postVideo=(Spinner)view.findViewById(R.id.spinner_linkvideo_commission);
        String[]postVideo_commissionItems=new String[]{"   ","TEST 1","TEST 2","TEST 3"};
        ArrayAdapter<String>adapter_postVideo_commission=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,postVideo_commissionItems){
            @Override
            public boolean isEnabled(int position) {
                if(position==0){
                    return  false;
                }
                else{
                    return  true;
                }
            }
        };
        spinner_commission_postVideo.setAdapter(adapter_postVideo_commission);
        spinner_commission_postVideo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_value_postVideo=(Spinner)view.findViewById(R.id.spinner_linkvideo_value);
        String[]postVideo_valuesItems=new String[]{"   ","TEST 1","TEST 2","TEST 3"};
        ArrayAdapter<String>adapter_postVideo_values=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,postVideo_valuesItems){
            @Override
            public boolean isEnabled(int position) {
               if(position==0){
                   return false;
               }
                else {
                   return true;
               }
            }
        };
        spinner_value_postVideo.setAdapter(adapter_postVideo_values);
        spinner_value_postVideo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //----------------------------------------------------------------------------------------------------------------

        return view;
    }

    @Override
    public void onClick(View view) {
  switch (view.getId()) {

case R.id.btn_expand_createads:
    Log.e("Message: ", "Opening expandable first layout");
    if(!expandableRelativeLayout_ads.isExpanded()){
        btn_createAds.setBackgroundResource(R.drawable.et_employer_background_gray);
        btn_linkvideo.setBackgroundResource(R.drawable.et_employer_background);
        btn_postjob.setBackgroundResource(R.drawable.et_employer_background);
    }
    if(expandableRelativeLayout_ads.isExpanded()){

        btn_createAds.setBackgroundResource(R.drawable.et_employer_background);
    }
    if(expandableRelativeLayout_video.isExpanded()){
       expandableRelativeLayout_video.collapse();
       expandableRelativeLayout_ads.expand();

    }
    else if (expandableRelativeLayout_job.isExpanded()){
         expandableRelativeLayout_job.collapse();
         expandableRelativeLayout_ads.expand();


    }
    else if(!expandableRelativeLayout_video.isExpanded()&&!expandableRelativeLayout_job.isExpanded()){
        expandableRelativeLayout_ads.toggle();

   }
   else if(expandableRelativeLayout_ads.isExpanded()&&expandableRelativeLayout_video.isExpanded()){
        expandableRelativeLayout_video.collapse();
   }
    break;

case R.id.btn_expand_linkvideo:
    if(!expandableRelativeLayout_video.isExpanded()){
        btn_linkvideo.setBackgroundResource(R.drawable.et_employer_background_gray);
        btn_createAds.setBackgroundResource(R.drawable.et_employer_background);
        btn_postjob.setBackgroundResource(R.drawable.et_employer_background);
    }
    if(expandableRelativeLayout_video.isExpanded()){

        btn_linkvideo.setBackgroundResource(R.drawable.et_employer_background);
    }

    Log.e("Message: ", "Opening expandable 2nd layout");
    if(expandableRelativeLayout_ads.isExpanded()){
         expandableRelativeLayout_ads.collapse();
         expandableRelativeLayout_video.expand();
    }
    else if (expandableRelativeLayout_job.isExpanded()){
        expandableRelativeLayout_job.collapse();
        expandableRelativeLayout_video.expand();
    }
    else if(!expandableRelativeLayout_ads.isExpanded()&&!expandableRelativeLayout_job.isExpanded()){
        expandableRelativeLayout_video.toggle();
    }
    else if(expandableRelativeLayout_ads.isExpanded()&&expandableRelativeLayout_ads.isExpanded()){
        expandableRelativeLayout_ads.collapse();


    }
    break;

case R.id.btn_expand_postjob:
    if(!expandableRelativeLayout_job.isExpanded()){
        btn_postjob.setBackgroundResource(R.drawable.et_employer_background_gray);
        btn_linkvideo.setBackgroundResource(R.drawable.et_employer_background);
        btn_createAds.setBackgroundResource(R.drawable.et_employer_background);
    }
    if(expandableRelativeLayout_job.isExpanded()){

        btn_postjob.setBackgroundResource(R.drawable.et_employer_background);
    }
    Log.e("Message: ", "Opening expandable 3rd layout");
    if(expandableRelativeLayout_video.isExpanded()){
        expandableRelativeLayout_video.collapse();
        expandableRelativeLayout_job.expand();
    }
    else if (expandableRelativeLayout_ads.isExpanded()){
         expandableRelativeLayout_ads.collapse();

         expandableRelativeLayout_job.expand();
    }
    else if(!expandableRelativeLayout_ads.isExpanded()&&!expandableRelativeLayout_video.isExpanded()){
        expandableRelativeLayout_job.toggle();
    }
    break;

case R.id.btn_createAds_postAds:
    Log.e("MESSAGE: ","USE POST AD BUTTON");
    break;

  }
    }

    public void RichEditor(View view){
        view.findViewById(R.id.action_undo).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.undo();
            }
        });

        view.findViewById(R.id.action_redo).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.redo();
            }
        });

        view.findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setBold();
            }
        });

        view.findViewById(R.id.action_italic).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setItalic();
            }
        });

        view.findViewById(R.id.action_subscript).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setSubscript();
            }
        });

        view.findViewById(R.id.action_superscript).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setSuperscript();
            }
        });

        view.findViewById(R.id.action_strikethrough).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setStrikeThrough();
            }
        });

        view.findViewById(R.id.action_underline).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setUnderline();
            }
        });

        view.findViewById(R.id.action_txt_color).setOnClickListener(new View.OnClickListener() {
            private boolean isChanged;

            @Override public void onClick(View v) {
                editor.setTextColor(isChanged ? Color.BLACK : Color.RED);
                isChanged = !isChanged;
            }
        });

        view.findViewById(R.id.action_bg_color).setOnClickListener(new View.OnClickListener() {
            private boolean isChanged;

            @Override public void onClick(View v) {
                editor.setTextBackgroundColor(isChanged ? Color.TRANSPARENT : Color.YELLOW);
                isChanged = !isChanged;
            }
        });

        view.findViewById(R.id.action_indent).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setIndent();
            }
        });

        view.findViewById(R.id.action_outdent).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setOutdent();
            }
        });

        view.findViewById(R.id.action_align_left).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setAlignLeft();
            }
        });

        view.findViewById(R.id.action_align_center).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setAlignCenter();
            }
        });

        view.findViewById(R.id.action_align_right).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.setAlignRight();
            }
        });
        view.findViewById(R.id.action_insert_image).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.insertImage("http://www.1honeywan.com/dachshund/image/7.21/7.21_3_thumb.JPG",
                        "dachshund");
            }
        });

        view.findViewById(R.id.action_insert_link).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.insertLink("https://github.com/wasabeef", "wasabeef");
            }
        });
        view.findViewById(R.id.action_insert_checkbox).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                editor.insertTodo();
            }
        });
    }


}

