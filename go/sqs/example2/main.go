package main
 
import (
	"fmt"
	"context"

	"github.com/aws/aws-lambda-go/events"
)
 
func main() {
	sess := InitSession()
	queueURL := "https://sqs.eu-west-1.amazonaws.com/0000000000000/queue"

	err := SendMsg(sess, &queueURL)
	if err != nil {
			fmt.Println("Got an error sending the message:")
			fmt.Println(err)
			return
	}

	// fmt.Println("Sent message to queue ")

	var timeout int64 = 5
	msgResult, err := GetMessages(sess, &queueURL, &timeout)
	if err != nil {
			fmt.Println("Got an error receiving messages:")
			fmt.Println(err)
			return
	}

	fmt.Println("Message ID:     " + *msgResult.Messages[0].MessageId)

	// snippet-start:[sqs.go.receive_messages.print_handle]
	fmt.Println("Message Handle: " + *msgResult.Messages[0].ReceiptHandle)
	fmt.Println("Message Handle: ", msgResult)
	// snippet-end:[sqs.go.receive_messages.print_handle]


	err = DeleteMessage(sess, &queueURL, msgResult.Messages[0].ReceiptHandle)
	if err != nil {
			fmt.Println("Got an error deleting the message:")
			fmt.Println(err)
			return
	}

	fmt.Println("Deleted message from queue with URL " + queueURL)
}

