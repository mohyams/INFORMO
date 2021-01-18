package com.example.mohit.fb;

/**
 * Created by Mohit on 02-04-2018.
 */

public class Upload {
    private String mEventName;
    private String mContent;
    private String mTime;
    private String mDate;
    private String mVenue;
    private String mImageUrl;

    public Upload(){
            //empty constructor needed

    }

    public Upload(String EventName,String Content,String Time,String Date,String Venue,String imageUrl)
    {
        this.mEventName = EventName;
        this.mContent = Content;
        this.mTime = Time;
        this.mDate = Date;
        this.mVenue = Venue;
        this.mImageUrl = imageUrl;
    }

    public String getEventName()
    {
        return mEventName;
    }

    public void setEventName(String EventName)
    {
        mEventName = EventName;
    }

    public String getContent()
    {
        return mContent;
    }

    public void setContent(String Content)
    {
        mContent = Content;
    }

    public String getTime()
    {
        return mTime;
    }

    public void setTime(String Time)
    {
        mTime = Time;
    }

    public String getDate()
    {
        return mDate;
    }

    public void setDate(String Date)
    {
        mDate = Date;
    }

    public String getVenue()
    {
        return mVenue;
    }

    public void setVenue(String Venue)
    {
        mVenue = Venue;
    }

    public String getImageUrl()
    {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        mImageUrl = imageUrl;
    }
}

