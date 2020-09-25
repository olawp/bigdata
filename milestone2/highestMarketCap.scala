val frame = spark.read.format("csv").option("header", true).option("inferSchema", "true").load("bitcoin_cash_price.csv")
val high = frame.select(max("Market Cap")).show()
