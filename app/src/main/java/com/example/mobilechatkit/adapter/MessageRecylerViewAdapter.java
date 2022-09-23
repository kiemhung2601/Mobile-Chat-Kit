package com.example.mobilechatkit.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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
import com.example.mobilechatkit.model.Chat;
import com.example.mobilechatkit.model.MessagesChat;

import java.util.List;

public class MessageRecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Chat> lstChat;
    private Activity activity;
    private int positionChat;

    public MessageRecylerViewAdapter(List<Chat> lstChat, Activity activity, int position) {
        this.lstChat = lstChat;
        this.activity = activity;
        this.positionChat = position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View itemView0 = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_host_layout, parent, false);
                return new ViewHolder0(itemView0);
            case 2:
                View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_guest_layout, parent, false);
                return new ViewHolder2(itemView2);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MessagesChat message = lstChat.get(positionChat).getLstMessage().get(position);
        if(message == null){
            return;
        }

        switch (holder.getItemViewType()) {
            case 0:
                ViewHolder0 viewHolder0 = (ViewHolder0)holder;
                viewHolder0.txtMessage.setText(message.getMessage());
                viewHolder0.txtMessage.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        Point p;

                        int[] location = new int[2];
                        // Get the x, y location and store it in the location[] array
                        // location[0] = x, location[1] = y.
                        viewHolder0.txtMessage.getLocationOnScreen(location);

                        //Initialize the Point with x, and y positions
                        p = new Point();
                        p.x = location[0];
                        p.y = location[1];

                        if(p != null){
                            String text = String.valueOf(viewHolder0.txtMessage.getText());
                            showPopup(activity, p, text, holder.getItemViewType());
                        }
                        return false;
                    }
                });
                break;

            case 2:
                ViewHolder2 viewHolder2 = (ViewHolder2)holder;
                viewHolder2.txtMessage.setText(message.getMessage());
                viewHolder2.txtMessage.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        Point p;

                        int[] location = new int[2];
                        // Get the x, y location and store it in the location[] array
                        // location[0] = x, location[1] = y.
                        viewHolder2.txtMessage.getLocationOnScreen(location);

                        //Initialize the Point with x, and y positions
                        p = new Point();
                        p.x = location[0];
                        p.y = location[1];

                        if(p != null){
                            String text = String.valueOf(viewHolder2.txtMessage.getText());
                            showPopup(activity, p, text, holder.getItemViewType());
                        }
                        return false;
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(lstChat.get(positionChat).getType() == true){
            return 0;
        } else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        return lstChat.get(positionChat).getLstMessage().size();
    }

    class ViewHolder0 extends RecyclerView.ViewHolder {
        private TextView txtMessage;

        public ViewHolder0(View itemView){
            super(itemView);
            txtMessage = itemView.findViewById(R.id.txt_message_host);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView txtMessage;

        public ViewHolder2(View itemView) {
            super(itemView);
            txtMessage = itemView.findViewById(R.id.txt_message_guest);
        }
    }

    private void showPopup(final Activity context, Point p, String text, int typeView) {

        int popupWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 280, context.getResources().getDisplayMetrics());
        int popupHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 350, context.getResources().getDisplayMetrics());;

        TextView txtMessage;
        View layout;

        if(typeView == 0){
            // Inflate the popup_layout.xml
            LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup_windows_host);
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = layoutInflater.inflate(R.layout.popup_windows_host_layout, viewGroup);

            txtMessage = layout.findViewById(R.id.txt_message_host);
        } else{
            // Inflate the popup_layout.xml
            LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup_windows_guest);
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = layoutInflater.inflate(R.layout.popup_windows_guest_layout, viewGroup);

            txtMessage = layout.findViewById(R.id.txt_message_guest);
        }

        txtMessage.setText(text);

        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(popupWidth);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X, OFFSET_Y;
        if(typeView == 0){
            OFFSET_X = popupWidth;
            OFFSET_Y = -130;
        } else {
            OFFSET_X = - popupWidth;
            OFFSET_Y = -130;
        }

        // Clear the default translucent background
        popup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

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
