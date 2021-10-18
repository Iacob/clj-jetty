(ns clj-jetty.core
  (:gen-class))

(defn -main
  "main function"
  [& args]

  (JettyTemplate.JettyRunner/setFunction
   (fn [target jettyRequest request response]
     (println "Hello")
     (. response setContentType "text/plain")
     (. (. response getWriter) print "Hola mondo.")
     ))

  (JettyTemplate.JettyRunner/start) )
