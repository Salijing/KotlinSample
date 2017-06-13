package important

/**
 * Created by chall on 2017/6/9.
 */
class CityForecast(val map: MutableMap<String, Any?>,
                   val dailyForecast: List<String>)
{
    var _id: Long by map
    var city: String by map
    var country: String by map
    constructor(id: Long, city: String, country: String,
                dailyForecast: List<String>)
            : this(HashMap(), dailyForecast) {
        this._id = id
        this.city = city
        this.country = country
    }
}