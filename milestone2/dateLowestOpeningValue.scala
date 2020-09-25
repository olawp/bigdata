val frame = spark.read.format("csv").option("header", true).option("inferSchema", "true").load("bitcoin_cash_price.csv")
val result = frame.orderBy(asc("open")).show(1)
