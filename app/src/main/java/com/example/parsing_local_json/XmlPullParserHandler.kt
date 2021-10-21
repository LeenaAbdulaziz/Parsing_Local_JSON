package com.example.parsing_local_json

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XmlPullParserHandler {
        private var Image = ArrayList<Image_details>()
        private var url=""
        private var text: String? = null


        fun parse(inputStream: InputStream): List<Image_details> {
            try {
                val factory = XmlPullParserFactory.newInstance()
                val parser = factory.newPullParser()
                parser.setInput(inputStream, null)
                var eventType = parser.eventType
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    val tagName = parser.name
                    when (eventType) {

                        XmlPullParser.TEXT -> text = parser.text
                        XmlPullParser.END_TAG ->  when {
                            tagName.equals("url", ignoreCase = true) ->{
                                url=text.toString()
                            }

                            else -> {
                                Image.add(Image_details(url))
                            }
                        }


                        else -> {
                        }

                    }
                    eventType = parser.next()

                }



            } catch (e: XmlPullParserException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return Image
        }
    }
