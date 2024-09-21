package com.example.np.presto.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.np.presto.Adapter.InstrumentAdapter;
import com.example.np.presto.Model.InstrumentModel;
import com.example.np.presto.Pojo.Instrument;
import com.example.np.presto.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class InstrumentFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RecyclerView instrRecView = (RecyclerView) inflater.inflate(R.layout.instr, container, false);
        registerForContextMenu(instrRecView);
        InstrumentModel instrumentModel = new InstrumentModel(instrRecView.getContext());

        List<Instrument> instrs = new ArrayList<>();
        Instrument firstInstr = new Instrument(getText(R.string.instr1).toString(), "D", R.drawable.bb,getText(R.string.instrprice1).toString());
        Instrument secondInstr = new Instrument(getText(R.string.instr2).toString(), "P132", R.drawable.p132,getText(R.string.instrprice4).toString());
        Instrument thirdInstr = new Instrument(getText(R.string.instr3).toString(), "H115", R.drawable.h115,getText(R.string.instrprice3).toString());
        Instrument fourthInstr = new Instrument(getText(R.string.instr4).toString(), "P132E", R.drawable.p132e,getText(R.string.instrprice4).toString());
        Instrument fifthInstr = new Instrument(getText(R.string.instr5).toString(), "M170", R.drawable.steinway,getText(R.string.instrprice5).toString());
        Instrument sixthInstr = new Instrument(getText(R.string.instr5).toString(), "O180", R.drawable.steinwayblack,getText(R.string.instrprice6).toString());
        Instrument seventhInstr = new Instrument(getText(R.string.instr5).toString(), "D Concert Grand", R.drawable.dconcertgrand,getText(R.string.instrprice7).toString());
        Instrument eighthInstr = new Instrument(getText(R.string.instr5).toString(), "A3", R.drawable.a3,getText(R.string.instrprice8).toString());

        instrs.add(firstInstr);
        instrs.add(secondInstr);
        instrs.add(thirdInstr);
        instrs.add(fourthInstr);
        instrs.add(fifthInstr);
        instrs.add(sixthInstr);
        instrs.add(seventhInstr);
        instrs.add(eighthInstr);

        instrumentModel.addInstrument(firstInstr);
        instrumentModel.addInstrument(secondInstr);
        instrumentModel.addInstrument(thirdInstr);
        instrumentModel.addInstrument(fourthInstr);
        instrumentModel.addInstrument(fifthInstr);
        instrumentModel.addInstrument(sixthInstr);
        instrumentModel.addInstrument(seventhInstr);
        instrumentModel.addInstrument(eighthInstr);

        InstrumentAdapter instrAdapter = new InstrumentAdapter(instrRecView.getContext(),instrs);

        instrRecView.setAdapter(instrAdapter);
        instrRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        return instrRecView;
    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.more:

                AlertDialog.Builder instrDetails = new AlertDialog.Builder(getContext());
                instrDetails.setCancelable(true);
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                assert inflater != null;
                final View editView = inflater.inflate(R.layout.instrmore_layout, null);
                instrDetails.setView(editView);
                final AlertDialog alertDialog = instrDetails.create();
                alertDialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
