package com.example.mobilechatkit.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilechatkit.R;
import com.example.mobilechatkit.model.MessagesChat;

import java.util.List;

public class MessageGuestAdapter extends RecyclerView.Adapter<MessageGuestAdapter.MessageGuestViewHolder> {

    private List<MessagesChat> lstMessage;
    private Activity activity;

    public MessageGuestAdapter(List<MessagesChat> lstMessage, Activity activity) {
        this.lstMessage = lstMessage;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MessageGuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_guest_layout, parent, false);
        return new MessageGuestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageGuestViewHolder holder, int position) {
        final MessagesChat message = lstMessage.get(position);
        if(message == null){
            return;
        }
        holder.txtMessage.setText(message.getMessage());

        holder.txtMessage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Point p;

                int[] location = new int[2];
                // Get the x, y location and store it in the location[] array
                // location[0] = x, location[1] = y.
                holder.txtMessage.getLocationOnScreen(location);

                String text = String.valueOf(holder.txtMessage.getText());


                //Initialize the Point with x, and y positions
                p = new Point();
                p.x = location[0];
                p.y = location[1];


                if(p != null){
                    showPopup(activity, p, text);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstMessage.size();
    }

    public class MessageGuestViewHolder extends RecyclerView.ViewHolder{
        private TextView txtMessage;

        public MessageGuestViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMessage = itemView.findViewById(R.id.txt_message_guest);
        }
    }

    private void showPopup(final Activity context, Point p, String text) {

        int popupWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 280, context.getResources().getDisplayMetrics());
        int popupHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 350, context.getResources().getDisplayMetrics());

        // Inflate the popup_layout.xml
        LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup_windows_guest);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_windows_guest_layout, viewGroup);

        TextView txtMessage = layout.findViewById(R.id.txt_message_guest);
        txtMessage.setText(text);

        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(popupWidth);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);


        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = - popupWidth;
        int OFFSET_Y = -130;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);
        dimBehind(popup);
    }

    public static void dimBehind(PopupWindow popupWindow) {
        View container;
        if (popupWindow.getBackground() == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                container = (View) popupWindow.getContentView().getParent();
            } else {
                container = popupWindow.getContentView();
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                container = (View) popupWindow.getContentView().getParent().getParent();
            } else {
                container = (View) popupWindow.getContentView().getParent();
            }
        }
        Context context = popupWindow.getContentView().getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
        p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        p.dimAmount = 0.6f;
        wm.updateViewLayout(container, p);
    }
}
