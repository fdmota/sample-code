package main

import (
	"fmt"
	"log"
	"os"

	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/credentials"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/sqs"
)

const (
	QueueUrl    = "https://sqs.eu-west-1.amazonaws.com/1111232321213/queue"
	Region      = "eu-west-1"
	CredPath    = "/home/user/.aws/credentials"
	CredProfile = "profilename"
)

func main() {

	sess := session.New(&aws.Config{
		Region:      aws.String(Region),
		Credentials: credentials.NewSharedCredentials(CredPath, CredProfile),
		MaxRetries:  aws.Int(5),
	})

	svc := sqs.New(sess)

	// Send message
	sendParams := &sqs.SendMessageInput{
		MessageBody:  aws.String("message body1"),
		QueueUrl:     aws.String(QueueUrl),
		DelaySeconds: aws.Int64(3),
	}
	sendResp, err := svc.SendMessage(sendParams)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Printf("[Send message] \n%v \n\n", sendResp)


	

	// Receive message
	receiveParams := &sqs.ReceiveMessageInput{
		QueueUrl:            aws.String(QueueUrl),
		MaxNumberOfMessages: aws.Int64(3),
		VisibilityTimeout:   aws.Int64(30),
		WaitTimeSeconds:     aws.Int64(20),
	}
	receiveResp, err := svc.ReceiveMessage(receiveParams)
	if err != nil {
		log.Println(err)
	}
	fmt.Printf("[Receive message] \n%v \n\n", receiveResp)

	// Delete message
	for _, message := range receiveResp.Messages {
		deleteParams := &sqs.DeleteMessageInput{
			QueueUrl:      aws.String(QueueUrl),
			ReceiptHandle: message.ReceiptHandle,

		}
		_, err := svc.DeleteMessage(deleteParams)
		if err != nil {
			log.Println(err)
		}
		fmt.Printf("[Delete message] \nMessage ID: %s has beed deleted.\n\n", *message.MessageId)
	}

	log.Println("Finished")
	os.Exit(0)
}
