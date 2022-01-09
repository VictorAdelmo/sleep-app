package com.example.sleep;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationMedia {

    public static final String CHANNEL_NOTIFICATION_ID = "notification_media";
    public static final String ACTION_PLAY = "actionplay";

    public static Notification notification;

    public static void createNotification(Context context, int playbutton, int img, String nome){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, "tag");

            Bitmap icon = BitmapFactory.decodeResource(context.getResources(),img);

            Intent intentPlay = new Intent(context,NotificationActionService.class)
                    .setAction(ACTION_PLAY);

            PendingIntent pendingIntentPlay = PendingIntent.getBroadcast(context,0
                    ,intentPlay
                    ,PendingIntent.FLAG_UPDATE_CURRENT);


            notification = new NotificationCompat.Builder(context,CHANNEL_NOTIFICATION_ID)
                    .setSmallIcon(R.mipmap.ic_meuapp)
                    .setContentTitle(nome)
                    .setLargeIcon(icon)
                    .setOnlyAlertOnce(true)
                    .setShowWhen(true)
                    .addAction(playbutton,"Play",pendingIntentPlay)
                        .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setMediaSession(mediaSessionCompat.getSessionToken()))
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .build();

            notificationManagerCompat.notify(1,notification);
        }
    }
}
