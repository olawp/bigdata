val frame = spark.read.format("csv").option("header", true).option("inferSchema", "true").load("bitcoin_cash_price.csv")
val high = frame.select(max("high")).withColumnRenamed("max(high)","highest")
val low = frame.select(min("low")).withColumnRenamed("min(low)","lowest")
val joined = low.join(high)
val result = joined.withColumn("difference",expr("highest - lowest"))

