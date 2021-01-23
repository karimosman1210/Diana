package com.mazad.Diana.adapter

//import com.google.firebase.database.*
import android.content.Context
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mazad.Diana.R
import com.mazad.Diana.data.MazadResponse
import com.mazad.Diana.gui.UserDetails.UserDetailsActivity
import com.mazad.Diana.gui.mazad_details.MazadDetailsActivity
import com.mazad.Diana.utels.AppConstant
import com.mazad.Diana.utels.AppKey
import com.mazad.Diana.utels.AppKey.BOOKED
import com.mazad.Diana.utels.AppKey.UNBOOKED
import com.mazad.Diana.utels.utels.IntentUtiles
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.util.*


class AdsAdapter() : RecyclerView.Adapter<AdsAdapter.VH>() {
    lateinit var adsList: List<MazadResponse>
    lateinit var context: Context
    lateinit var EndTimeDetails: String
    private lateinit var countDownTimer: CountDownTimer


    constructor(context: Context, adsList: List<MazadResponse>) : this() {
        this.adsList = adsList
        this.context = context

    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameUserTv: TextView
        var descTv: TextView
        var endPriceTv: TextView
        var startPriceTv: TextView
        var countDownTimerTextView: TextView
        var imgeAdIv: ImageView
        var bookedIv: ImageView
        var interMazadBtn: Button
        var imgeProfileCv: CircleImageView


        init {
            nameUserTv = itemView.findViewById(R.id.nameUserTv)
            descTv = itemView.findViewById(R.id.descTv)
            startPriceTv = itemView.findViewById(R.id.startPriceTv)
            endPriceTv = itemView.findViewById(R.id.endPriceTv)
            countDownTimerTextView = itemView.findViewById(R.id.countDownTimerTextView)
            imgeAdIv = itemView.findViewById(R.id.imgeAdIv)
            interMazadBtn = itemView.findViewById(R.id.interMazadBtn)
            imgeProfileCv = itemView.findViewById(R.id.imgeProfileCv)
            bookedIv = itemView.findViewById(R.id.bookedIv)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_money, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return adsList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val adsModel: MazadResponse = adsList.get(position)
        holder.descTv.text = adsList[position].generalDescription

            holder.startPriceTv.text = adsList[position].price.toString()+" جنيه "
            holder.endPriceTv.text = adsList[position].newPrice.toString()+" جنيه "

        if (adsModel.mazadFinished==UNBOOKED){
            holder.bookedIv.visibility=View.GONE
        }else if (adsModel.mazadFinished==BOOKED){
            holder.bookedIv.visibility=View.VISIBLE

        }


       // holder.nameUserTv.text = "" + name
            Picasso.get().load(AppConstant.BASE_IMAGE + adsModel.img1).into(holder.imgeAdIv)

        Picasso.get().load(AppConstant.BASE_IMAGE + adsModel.users.image).into(holder.imgeProfileCv)
        holder.nameUserTv.setText(adsModel.users.firstName)

        holder.imgeProfileCv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val bundle = Bundle()
                bundle.putParcelable(AppKey.userData, adsModel.getUsers())
                IntentUtiles.openActivity(
                    context,
                    UserDetailsActivity::class.java, bundle, false
                )
            }
        })

        var st: String = adsList[position].mazadEndDate
//        EndTimeDetails = adsList[position].end_time
        printDifferenceDateForHours(
            adsModel.mazadEndDate,
            holder.countDownTimerTextView,
            adsModel.timePublish
        )

        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                val intent = Intent(context,MazadDetailsActivity::class.java)
                intent.putExtra("adsModel",adsModel)
                context.startActivity(intent)
            }
        })

    }

    fun printDifferenceDateForHours(endDateDay: String, dateTv: TextView, timePublish: String) {
        val format1 = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
//        val format2 = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault())
        val endDate = format1.parse(timePublish)
        val startDate = format1.parse(endDateDay)
        val currentDate = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(Date())

        val date2: Date = format1.parse(currentDate)

        //milliseconds
        var different =  startDate.time -date2.time
        countDownTimer = object : CountDownTimer(different, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                var diff = millisUntilFinished
                val secondsInMilli: Long = 1000
                val minutesInMilli = secondsInMilli * 60
                val hoursInMilli = minutesInMilli * 60
                val daysInMilli = hoursInMilli * 24

                val elapsedDays = diff / daysInMilli
                diff %= daysInMilli

                val elapsedHours = diff / hoursInMilli
                diff %= hoursInMilli

                val elapsedMinutes = diff / minutesInMilli
                diff %= minutesInMilli

                val elapsedSeconds = diff / secondsInMilli

                dateTv.text =
                    "$elapsedDays days $elapsedHours hs $elapsedMinutes min $elapsedSeconds sec"
            }

            override fun onFinish() {

                dateTv.text = "انتهي!"

            }
        }.start()
    }

    fun getDaysDifference(fromDate: Date?, toDate: Date?): Int {
        return if (fromDate == null || toDate == null) 0 else ((toDate.time - fromDate.time) / (1000 * 60 * 60 * 24)).toInt()
    }

}