package com.example.minh1trinh.twowayscroll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh1.trinh on 12/5/2017.
 * Support save checkBox
 */

public class TableMainLayoutCheckBox extends RelativeLayout {
    //  public final String TAG = "TableMainLayout.java";

    // set the header titles
    String headers[] = {
            "Header 1 n multi-lines",
            "Header 2",
            "Header 3",
            "Header 4",
            "Header 5",
            "Header 6",
            "Header 7",
            "Header 8",
            "Header 9",
            "Header 10",
            "Header 11",
            "Header 12",
            "Header 13",
            "Header 14",
            "Header 15",
            "Header 16",
            "Header 17",
            "Header 18",
            "Header 19",
            "Header 20"


    };


    TableLayout tableA;
    TableLayout tableB;
    TableLayout tableC;
    TableLayout tableD;

    HorizontalScrollView horizontalScrollViewB;
    HorizontalScrollView horizontalScrollViewD;

    ScrollView scrollViewC;
    ScrollView scrollViewD;

    Context context;

    List<ObjectCheckbox> sampleObjects = this.sampleObjects();

    int headerCellsWidth[] = new int[headers.length];

    public TableMainLayoutCheckBox(Context context) {

        super(context);

        this.context = context;

        // initialize the main components (TableLayouts, HorizontalScrollView, ScrollView)
        this.initComponents();
        this.setComponentsId();
        this.setScrollViewAndHorizontalScrollViewTag();


        // no need to assemble component A, since it is just a table
        this.horizontalScrollViewB.addView(this.tableB);

        this.scrollViewC.addView(this.tableC);

        this.scrollViewD.addView(this.horizontalScrollViewD);
        this.horizontalScrollViewD.addView(this.tableD);

        // add the components to be part of the main layout
        this.addComponentToMainLayout();
        this.setBackgroundColor(Color.RED);


        // add some table rows
        this.addTableRowToTableA();
        this.addTableRowToTableB();

        this.resizeHeaderHeight();

        this.getTableRowHeaderCellWidth();

        this.generateTableC_AndTable_B();

        this.resizeBodyTableRowHeight();
    }

    // this is just the sample data
    List<ObjectCheckbox> sampleObjects() {

        List<SampleObject> sampleObjects = new ArrayList<>();
        List<ObjectCheckbox>sampleCheckBox = new ArrayList<>();


        for (int x = 1; x <= 20; x++) {
            CheckBox checkBox1 = new CheckBox(getContext());
            checkBox1.setText("Col 1, Row " + x);
            checkBox1.setChecked(false);

            CheckBox checkBox2 = new CheckBox(getContext());
            checkBox2.setText("Col 2, Row " + x);
            checkBox2.setChecked(false);

            CheckBox checkBox3 = new CheckBox(getContext());
            checkBox3.setText("Col 3, Row " + x);
            checkBox3.setChecked(false);

            CheckBox checkBox4 = new CheckBox(getContext());
            checkBox4.setText("Col 4, Row " + x);
            checkBox4.setChecked(false);

            CheckBox checkBox5 = new CheckBox(getContext());
            checkBox5.setText("Col 5, Row " + x);
            checkBox5.setChecked(false);

            CheckBox checkBox6 = new CheckBox(getContext());
            checkBox6.setText("Col 6, Row " + x);
            checkBox6.setChecked(false);

            CheckBox checkBox7 = new CheckBox(getContext());
            checkBox7.setText("Col 7, Row " + x);
            checkBox7.setChecked(false);

            CheckBox checkBox8 = new CheckBox(getContext());
            checkBox8.setText("Col 8, Row " + x);
            checkBox8.setChecked(false);

            CheckBox checkBox9 = new CheckBox(getContext());
            checkBox9.setText("Col 9, Row " + x);
            checkBox9.setChecked(false);

            CheckBox checkBox10 = new CheckBox(getContext());
            checkBox10.setText("Col 10, Row " + x);
            checkBox10.setChecked(false);

            CheckBox checkBox11 = new CheckBox(getContext());
            checkBox11.setText("Col 11, Row " + x);
            checkBox11.setChecked(false);

            CheckBox checkBox12 = new CheckBox(getContext());
            checkBox12.setText("Col 12, Row " + x);
            checkBox12.setChecked(false);

            CheckBox checkBox13 = new CheckBox(getContext());
            checkBox13.setText("Col 13, Row " + x);
            checkBox13.setChecked(false);

            CheckBox checkBox14 = new CheckBox(getContext());
            checkBox14.setText("Col 14, Row " + x);
            checkBox14.setChecked(false);

            CheckBox checkBox15 = new CheckBox(getContext());
            checkBox15.setText("Col 15, Row " + x);
            checkBox15.setChecked(false);

            CheckBox checkBox16 = new CheckBox(getContext());
            checkBox16.setText("Col 16, Row " + x);
            checkBox16.setChecked(false);

            CheckBox checkBox17 = new CheckBox(getContext());
            checkBox17.setText("Col 17, Row " + x);
            checkBox17.setChecked(false);

            CheckBox checkBox18 = new CheckBox(getContext());
            checkBox18.setText("Col 18, Row " + x);
            checkBox18.setChecked(false);

            CheckBox checkBox19 = new CheckBox(getContext());
            checkBox19.setText("Col 19, Row " + x);
            checkBox19.setChecked(false);

            CheckBox checkBox20 = new CheckBox(getContext());
            checkBox20.setText("Col 20, Row " + x);
            checkBox20.setChecked(false);

            ObjectCheckbox objectCheckbox = new ObjectCheckbox(checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,
                    checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,
                    checkBox18,checkBox19,checkBox20);
            sampleCheckBox.add(objectCheckbox);


            SampleObject sampleObject = new SampleObject(
                    "Col 1, Row " + x,
                    "Col 2, Row " + x + " - multi-lines",
                    "Col 3, Row " + x,
                    "Col 4, Row " + x,
                    "Col 5, Row " + x,
                    "Col 6, Row " + x,
                    "Col 7, Row " + x,
                    "Col 8, Row " + x,
                    "Col 9, Row " + x,
                    "Col 10, Row " + x,
                    "Col 11, Row " + x,
                    "Col 12, Row " + x,
                    "Col 13, Row " + x,
                    "Col 14, Row " + x,
                    "Col 15, Row " + x,
                    "Col 16, Row " + x,
                    "Col 17, Row " + x,
                    "Col 18, Row " + x,
                    "Col 19, Row " + x,
                    "Col 20, Row " + x

            );


        }

        return sampleCheckBox;

    }

    // Initalized components
    private void initComponents() {

        this.tableA = new TableLayout(this.context);
        this.tableB = new TableLayout(this.context);
        this.tableC = new TableLayout(this.context);
        this.tableD = new TableLayout(this.context);

        this.horizontalScrollViewB = new TableMainLayoutCheckBox.MyHorizontalScrollView(this.context);
        this.horizontalScrollViewD = new TableMainLayoutCheckBox.MyHorizontalScrollView(this.context);

        this.scrollViewC = new TableMainLayoutCheckBox.MyScrollView(this.context);
        this.scrollViewD = new TableMainLayoutCheckBox.MyScrollView(this.context);

        this.tableA.setBackgroundColor(Color.GREEN);
        this.horizontalScrollViewB.setBackgroundColor(Color.LTGRAY);

    }

    // set essential component IDs
    @SuppressLint("ResourceType")
    private void setComponentsId() {
        this.tableA.setId(1);
        this.horizontalScrollViewB.setId(2);
        this.scrollViewC.setId(3);
        this.scrollViewD.setId(4);
    }

    // set tags for some horizontal and vertical scroll view
    private void setScrollViewAndHorizontalScrollViewTag() {

        this.horizontalScrollViewB.setTag("horizontal scroll view b");
        this.horizontalScrollViewD.setTag("horizontal scroll view d");

        this.scrollViewC.setTag("scroll view c");
        this.scrollViewD.setTag("scroll view d");
    }

    // we add the components here in our TableMainLayout
    private void addComponentToMainLayout() {

        // RelativeLayout params were very useful here
        // the addRule method is the key to arrange the components properly
        RelativeLayout.LayoutParams componentB_Params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        componentB_Params.addRule(RelativeLayout.RIGHT_OF, this.tableA.getId());

        RelativeLayout.LayoutParams componentC_Params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        componentC_Params.addRule(RelativeLayout.BELOW, this.tableA.getId());

        RelativeLayout.LayoutParams componentD_Params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        componentD_Params.addRule(RelativeLayout.RIGHT_OF, this.scrollViewC.getId());
        componentD_Params.addRule(RelativeLayout.BELOW, this.horizontalScrollViewB.getId());

        // 'this' is a relative layout,
        // we extend this table layout as relative layout as seen during the creation of this class
        this.addView(this.tableA);
        this.addView(this.horizontalScrollViewB, componentB_Params);
        this.addView(this.scrollViewC, componentC_Params);
        this.addView(this.scrollViewD, componentD_Params);

    }


    private void addTableRowToTableA() {
        this.tableA.addView(this.componentATableRow());
    }

    private void addTableRowToTableB() {
        this.tableB.addView(this.componentBTableRow());
    }

    // generate table row of table A
    TableRow componentATableRow() {

        TableRow componentATableRow = new TableRow(this.context);
        TextView textView = this.headerTextView(this.headers[0]);
        componentATableRow.addView(textView);

        return componentATableRow;
    }

    // generate table row of table B
    TableRow componentBTableRow() {

        TableRow componentBTableRow = new TableRow(this.context);
        int headerFieldCount = this.headers.length;

        TableRow.LayoutParams params = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        params.setMargins(2, 0, 0, 0);

        for (int x = 0; x < (headerFieldCount - 1); x++) {
            TextView textView = this.headerTextView(this.headers[x + 1]);
            textView.setLayoutParams(params);
            componentBTableRow.addView(textView);
        }

        return componentBTableRow;
    }

    // generate table row of table C and table D
    private void generateTableC_AndTable_B() {

        // just seeing some header cell width
        for (int aHeaderCellsWidth : this.headerCellsWidth) {
            Log.v("TableMainLayout.java", aHeaderCellsWidth + "");
        }

    /*    for (SampleObject sampleObject : this.sampleObjects) {

            TableRow tableRowForTableC = this.tableRowForTableC(sampleObject);
            TableRow taleRowForTableD = this.taleRowForTableD(sampleObject);

            tableRowForTableC.setBackgroundColor(Color.LTGRAY);
            taleRowForTableD.setBackgroundColor(Color.LTGRAY);

            this.tableC.addView(tableRowForTableC);
            this.tableD.addView(taleRowForTableD);

        }*/
    }

    // a TableRow for table C
    TableRow tableRowForTableC(SampleObject sampleObject) {

        TableRow.LayoutParams params = new TableRow.LayoutParams(this.headerCellsWidth[0], LayoutParams.MATCH_PARENT);
        params.setMargins(0, 2, 0, 0);

        TableRow tableRowForTableC = new TableRow(this.context);
        TextView textView = this.bodyTextView(sampleObject.header1);
        tableRowForTableC.addView(textView, params);

        return tableRowForTableC;
    }

    TableRow taleRowForTableD(SampleObject sampleObject) {

        TableRow taleRowForTableD = new TableRow(this.context);

        int loopCount = ((TableRow) this.tableB.getChildAt(0)).getChildCount();
        String info[] = {
                sampleObject.header2,
                sampleObject.header3,
                sampleObject.header4,
                sampleObject.header5,
                sampleObject.header6,
                sampleObject.header7,
                sampleObject.header8,
                sampleObject.header9,
                sampleObject.header10,
                sampleObject.header11,
                sampleObject.header12,
                sampleObject.header13,
                sampleObject.header14,
                sampleObject.header15,
                sampleObject.header16,
                sampleObject.header17,
                sampleObject.header18,
                sampleObject.header19,
                sampleObject.header20,

        };

        for (int x = 0; x < loopCount; x++) {
            TableRow.LayoutParams params = new TableRow.LayoutParams(headerCellsWidth[x + 1], LayoutParams.MATCH_PARENT);
            params.setMargins(2, 2, 0, 0);

            TextView textViewB = this.bodyTextView(info[x]);
            taleRowForTableD.addView(textViewB, params);
        }

        return taleRowForTableD;

    }

    // table cell standard TextView
    TextView bodyTextView(String label) {

        TextView bodyTextView = new TextView(this.context);
        bodyTextView.setBackgroundColor(Color.WHITE);
        bodyTextView.setText(label);
        bodyTextView.setGravity(Gravity.CENTER);
        bodyTextView.setPadding(5, 5, 5, 5);

        return bodyTextView;
    }

    // header standard TextView
    TextView headerTextView(String label) {

        TextView headerTextView = new TextView(this.context);
        headerTextView.setBackgroundColor(Color.WHITE);
        headerTextView.setText(label);
        headerTextView.setGravity(Gravity.CENTER);
        headerTextView.setPadding(5, 5, 5, 5);

        return headerTextView;
    }

    // resizing TableRow height starts here
    void resizeHeaderHeight() {

        TableRow productNameHeaderTableRow = (TableRow) this.tableA.getChildAt(0);
        TableRow productInfoTableRow = (TableRow) this.tableB.getChildAt(0);

        int rowAHeight = this.viewHeight(productNameHeaderTableRow);
        int rowBHeight = this.viewHeight(productInfoTableRow);

        TableRow tableRow = rowAHeight < rowBHeight ? productNameHeaderTableRow : productInfoTableRow;
        int finalHeight = rowAHeight > rowBHeight ? rowAHeight : rowBHeight;

        this.matchLayoutHeight(tableRow, finalHeight);
    }

    void getTableRowHeaderCellWidth() {

        int tableAChildCount = ((TableRow) this.tableA.getChildAt(0)).getChildCount();
        int tableBChildCount = ((TableRow) this.tableB.getChildAt(0)).getChildCount();

        for (int x = 0; x < (tableAChildCount + tableBChildCount); x++) {

            if (x == 0) {
                this.headerCellsWidth[x] = this.viewWidth(((TableRow) this.tableA.getChildAt(0)).getChildAt(x));
            } else {
                this.headerCellsWidth[x] = this.viewWidth(((TableRow) this.tableB.getChildAt(0)).getChildAt(x - 1));
            }

        }
    }

    // resize body table row height
    void resizeBodyTableRowHeight() {

        int tableC_ChildCount = this.tableC.getChildCount();

        for (int x = 0; x < tableC_ChildCount; x++) {

            TableRow productNameHeaderTableRow = (TableRow) this.tableC.getChildAt(x);
            TableRow productInfoTableRow = (TableRow) this.tableD.getChildAt(x);

            int rowAHeight = this.viewHeight(productNameHeaderTableRow);
            int rowBHeight = this.viewHeight(productInfoTableRow);

            TableRow tableRow = rowAHeight < rowBHeight ? productNameHeaderTableRow : productInfoTableRow;
            int finalHeight = rowAHeight > rowBHeight ? rowAHeight : rowBHeight;

            this.matchLayoutHeight(tableRow, finalHeight);
        }

    }

    // match all height in a table row
    // to make a standard TableRow height
    private void matchLayoutHeight(TableRow tableRow, int height) {

        int tableRowChildCount = tableRow.getChildCount();

        // if a TableRow has only 1 child
        if (tableRow.getChildCount() == 1) {

            View view = tableRow.getChildAt(0);
            TableRow.LayoutParams params = (TableRow.LayoutParams) view.getLayoutParams();
            params.height = height - (params.bottomMargin + params.topMargin);

            return;
        }

        // if a TableRow has more than 1 child
        for (int x = 0; x < tableRowChildCount; x++) {

            View view = tableRow.getChildAt(x);

            TableRow.LayoutParams params = (TableRow.LayoutParams) view.getLayoutParams();

            if (!isTheHeighestLayout(tableRow, x)) {
                params.height = height - (params.bottomMargin + params.topMargin);
                return;
            }
        }

    }

    // check if the view has the highest height in a TableRow
    private boolean isTheHeighestLayout(TableRow tableRow, int layoutPosition) {

        int tableRowChildCount = tableRow.getChildCount();
        int heighestViewPosition = -1;
        int viewHeight = 0;

        for (int x = 0; x < tableRowChildCount; x++) {
            View view = tableRow.getChildAt(x);
            int height = this.viewHeight(view);

            if (viewHeight < height) {
                heighestViewPosition = x;
                viewHeight = height;
            }
        }

        return heighestViewPosition == layoutPosition;
    }

    // read a view's height
    private int viewHeight(View view) {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        return view.getMeasuredHeight();
    }

    // read a view's width
    private int viewWidth(View view) {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        return view.getMeasuredWidth();
    }

    // horizontal scroll view custom class
    class MyHorizontalScrollView extends HorizontalScrollView {

        public MyHorizontalScrollView(Context context) {
            super(context);
        }

        @Override
        protected void onScrollChanged(int l, int t, int oldl, int oldt) {
            String tag = (String) this.getTag();

            if (tag.equalsIgnoreCase("horizontal scroll view b")) {
                horizontalScrollViewD.scrollTo(l, 0);
            } else {
                horizontalScrollViewB.scrollTo(l, 0);
            }
        }

    }

    // scroll view custom class
    class MyScrollView extends ScrollView {

        public MyScrollView(Context context) {
            super(context);
        }

        @Override
        protected void onScrollChanged(int l, int t, int oldl, int oldt) {

            String tag = (String) this.getTag();

            if (tag.equalsIgnoreCase("scroll view c")) {
                scrollViewD.scrollTo(0, t);
            } else {
                scrollViewC.scrollTo(0, t);
            }
        }
    }
}
