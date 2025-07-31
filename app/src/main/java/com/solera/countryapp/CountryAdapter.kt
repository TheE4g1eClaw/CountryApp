package mx.com.solera.exploradordepaises

class CountryAdapter (private val country: List<Country>):RecyclerView.Adapter<CountryAdapter.ViewHolder> (){
}
class ViewHolder(view:View): RecyclerView.ViewHolder(view){

    /*
    *     val alpha3code : String,
    val name: String,
    val subregion: String,
    val image:String
    * */
    val flags: ImageView = view.findViewById(R.id.flags)
    val alpha3code:TextView = view.findViewById(R.id.tvName)
    val name : TextView = view.findViewById(R.id.tvName)
    val subregion : TextView = view.findViewById(R.id.tvSpecie)
}
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.country_item,parent,false)
    return ViewHolder(view)
}

override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val __country = country[position]
    holder.name.text = __country.name
    holder.subregion.text = --__country.subregion

    Glide.with(holder.itemView.context)
        .load(country.image)
        .into(holder.flags)
}

