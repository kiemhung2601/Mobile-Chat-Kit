package com.example.mobilechatkit;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilechatkit.adapter.MyViewHolder;
import com.example.mobilechatkit.adapter.RecyclerViewHorizontalAdapter;
import com.example.mobilechatkit.adapter.SwipeAdapter;
import com.example.mobilechatkit.databinding.FragmentChatsBinding;
import com.example.mobilechatkit.model.Message;
import com.example.mobilechatkit.my_interface.IClickItemListener;
import com.example.mobilechatkit.my_interface.ItemTouchHelperListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment implements ItemTouchHelperListener {

    private final View viewParent;

    public ChatsFragment(View viewParent) {
        this.viewParent = viewParent;
    }

    private List<Message> lstMessage = new ArrayList<>();
    SwipeAdapter swipeAdapter;
    LinearLayoutManager layoutManager;


    FragmentChatsBinding biding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        biding.rcvMess.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        biding.rcvMess.setLayoutManager(layoutManager);

        lstMessage = getListMessage();

        NavController navController = Navigation.findNavController(viewParent);

        swipeAdapter = new SwipeAdapter(lstMessage, new IClickItemListener() {
            @Override
            public void onLongClickItemUser(Message mesage) {
                clickOpenBottomSheetDialog(view);
            }

            @Override
            public void onClickItemUser(Message message) {
                navController.navigate(R.id.action_homeFragment_to_messageViewFragment2);
            }
        });

        biding.rcvMess.setAdapter(swipeAdapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new RecylerViewItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(biding.rcvMess);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        biding = FragmentChatsBinding.inflate(inflater, container, false);
        return biding.getRoot();
    }

    private List<Message> getListMessage(){
        List<Message> lstMessage = new ArrayList<>();
        lstMessage.add(new Message(R.drawable.avatar_1, "Photographers", "@andrewJ: do you like this imgur picture?", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_2, "Baker Hayfield", "@andrewJ: do you like this imgur picture? Another aspect is that the sun", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_3, "Regina Jones", "@andrewJ: Another aspect is that the sun? do you like this imgur picture?", "3:00 PM"));

        lstMessage.add(new Message(R.drawable.avatar_1, "Photographers", "@andrewJ: do you like this imgur picture?", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_2, "Baker Hayfield", "@andrewJ: do you like this imgur picture? Another aspect is that the sun", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_3, "Regina Jones", "@andrewJ: Another aspect is that the sun? do you like this imgur picture?", "3:00 PM"));

        lstMessage.add(new Message(R.drawable.avatar_1, "Photographers", "@andrewJ: do you like this imgur picture?", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_2, "Baker Hayfield", "@andrewJ: do you like this imgur picture? Another aspect is that the sun", "3:00 PM"));
        lstMessage.add(new Message(R.drawable.avatar_3, "Regina Jones", "@andrewJ: Another aspect is that the sun? do you like this imgur picture?", "3:00 PM"));


        return lstMessage;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder) {
        if(viewHolder instanceof MyViewHolder) {
            String nameUserDelete = lstMessage.get(viewHolder.getAdapterPosition()).getName();

            Message messageDelete = lstMessage.get(viewHolder.getAdapterPosition());
            int indexDelete = viewHolder.getAdapterPosition();

            //remove item
            swipeAdapter.removeItem(indexDelete);

            Snackbar snackbar = Snackbar.make(biding.rootView, nameUserDelete + " removed!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    swipeAdapter.undoItem(messageDelete, indexDelete);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }

    private void clickOpenBottomSheetDialog(View view){
        View viewDialog = getLayoutInflater().inflate(R.layout.fragment_modal_bottom_sheet_layout, null);

        List<Message> lstMessage;
        RecyclerView recyclerViewBottom;
        RecyclerViewHorizontalAdapter recyclerViewHorizontalAdapter;
        LinearLayoutManager layoutManagerBottom;

        recyclerViewBottom = viewDialog.findViewById(R.id.recycler_view_horizontal);

        recyclerViewBottom.setHasFixedSize(true);
        layoutManagerBottom = new LinearLayoutManager(viewDialog.getContext(), RecyclerView.HORIZONTAL, false);
        recyclerViewBottom.setLayoutManager(layoutManagerBottom);

        lstMessage = getListMessage();

        recyclerViewHorizontalAdapter = new RecyclerViewHorizontalAdapter(viewDialog.getContext(), lstMessage);
        recyclerViewBottom.setAdapter(recyclerViewHorizontalAdapter);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.BottomSheetDialogTheme);
        bottomSheetDialog.setContentView(viewDialog);
        bottomSheetDialog.show();
    }
}