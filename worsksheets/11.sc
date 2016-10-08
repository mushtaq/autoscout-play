{
  trait Day
  object Weekday extends Day
  object Weekend extends Day

  trait Customer
  object Rewards extends Customer
  object Regular extends Customer

  case class Category(day: Day, customer: Customer)
  
  case class Hotel(name: String, rating: Int, rates: Map[Category, Int]) {
    def costOf(bookingRequest: BookingRequest): Int =
      bookingRequest.categories.map(rates).sum
  }

  case class BookingRequest(customer: Customer, days: List[Day]) {
    def categories: List[Category] = days.map(day => Category(day, customer))
  }

  case class BookingService(hotels: Hotel*) {
    def bestHotel(bookingRequest: BookingRequest): String =
      hotels.minBy(h => (h.costOf(bookingRequest), -h.rating)).name
  }
}
