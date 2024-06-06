# working with instructions
FROM ubuntu:18.04
RUN apt-get update && apt-get install -y iputils-ping apache2

ENV var1=ping var2=8.8.8.8
VOLUME /foo-bar
CMD $var1 $var2
#entrypoint: cannot be overwritten in runtime
#ENTRYPOINT ["apache2ctl"] 
