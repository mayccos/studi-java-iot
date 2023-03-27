FROM rabbitmq:3.9.20-alpine

ENV RABBITMQ_PID_FILE /var/lib/rabbitmq/mnesia/rabbitmq
COPY config/definitions.json /etc/rabbitmq/definitions.json
ADD init.sh /init.sh
RUN chmod +x /init.sh

EXPOSE 15692 5672
CMD ["/init.sh"]
#ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["rabbitmq-server"]